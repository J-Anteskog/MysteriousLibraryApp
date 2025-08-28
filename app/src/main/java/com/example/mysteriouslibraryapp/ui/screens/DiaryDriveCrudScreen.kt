package com.example.mysteriouslibraryapp.ui.screens

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.client.http.FileContent
import com.google.api.services.drive.Drive
import com.google.api.services.drive.DriveScopes
import com.google.api.services.drive.model.File as DriveFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

data class DiaryEntry(
    val id: String,
    val text: String,
    val imageUrl: String? = null,
    val createdAt: String = ""
)

fun getDriveService(context: Context, account: com.google.android.gms.auth.api.signin.GoogleSignInAccount): Drive {
    val credential = GoogleAccountCredential.usingOAuth2(
        context,
        listOf(DriveScopes.DRIVE_FILE)
    )
    credential.selectedAccount = account.account

    return Drive.Builder(
        com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport(),
        com.google.api.client.json.gson.GsonFactory.getDefaultInstance(),
        credential
    ).setApplicationName("MysteriousLibraryApp")
        .build()
}

// CREATE: Skapa inlägg
suspend fun saveDiaryEntryToDrive(
    context: Context,
    driveService: Drive,
    diaryText: String,
    imageUri: Uri?
): DiaryEntry? {
    val sdf = SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.getDefault())
    val now = Date()
    val folderName = "Diary_${sdf.format(now)}"
    // Skapa mapp
    val folderMetadata = DriveFile()
    folderMetadata.name = folderName
    folderMetadata.mimeType = "application/vnd.google-apps.folder"
    val folder = driveService.files().create(folderMetadata)
        .setFields("id")
        .execute()
    val folderId = folder.id

    // Spara texten som fil i mappen
    val textFile = File.createTempFile("diary", ".txt", context.cacheDir)
    textFile.writeText(diaryText)
    val textMetadata = DriveFile()
    textMetadata.name = "entry.txt"
    textMetadata.parents = listOf(folderId)
    val textContent = FileContent("text/plain", textFile)
    driveService.files().create(textMetadata, textContent).execute()
    textFile.delete()

    // Spara bilden om sådan finns
    var imageDriveUrl: String? = null
    if (imageUri != null) {
        val inputStream = context.contentResolver.openInputStream(imageUri)
        val tempImage = File.createTempFile("diaryimg", ".jpg", context.cacheDir)
        inputStream?.use { input ->
            tempImage.outputStream().use { output ->
                input.copyTo(output)
            }
        }
        val imgMetadata = DriveFile()
        imgMetadata.name = "image.jpg"
        imgMetadata.parents = listOf(folderId)
        val imgContent = FileContent("image/jpeg", tempImage)
        val uploadedImage = driveService.files().create(imgMetadata, imgContent)
            .setFields("id,webContentLink,webViewLink")
            .execute()

        // Gör bilden publikt tillgänglig
        val permission = com.google.api.services.drive.model.Permission()
        permission.type = "anyone"
        permission.role = "reader"
        driveService.permissions().create(uploadedImage.id, permission).execute()

        tempImage.delete()
        imageDriveUrl = uploadedImage.webContentLink ?: uploadedImage.webViewLink
    }

    return DiaryEntry(
        id = folderId,
        text = diaryText,
        imageUrl = imageDriveUrl,
        createdAt = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(now)
    )
}

// READ: Läs alla dagboksinlägg (mappar) från Drive
suspend fun loadAllDiaryEntriesFromDrive(
    driveService: Drive
): List<DiaryEntry> {
    val entries = mutableListOf<DiaryEntry>()
    // Hämta alla mappar med namn som börjar på "Diary_"
    val folderList = driveService.files().list()
        .setQ("mimeType = 'application/vnd.google-apps.folder' and name contains 'Diary_' and trashed = false")
        .setFields("files(id, name, createdTime)")
        .execute()
    for (folder in folderList.files) {
        var diaryText = ""
        var imageUrl: String? = null
        // Hämta filer i mappen
        val fileList = driveService.files().list()
            .setQ("'${folder.id}' in parents and trashed = false")
            .setFields("files(id, name, mimeType, webContentLink, webViewLink)")
            .execute()
        for (file in fileList.files) {
            when {
                file.name.endsWith(".txt") -> {
                    // Läs textfilen
                    val inputStream = driveService.files().get(file.id).executeMediaAsInputStream()
                    diaryText = inputStream.bufferedReader().readText()
                }
                file.mimeType.startsWith("image") -> {
                    imageUrl = file.webContentLink ?: file.webViewLink
                }
            }
        }
        entries.add(
            DiaryEntry(
                id = folder.id,
                text = diaryText,
                imageUrl = imageUrl,
                createdAt = folder.createdTime?.toString() ?: ""
            )
        )
    }
    // Sortera senaste först
    return entries.sortedByDescending { it.createdAt }
}

// UPDATE: Uppdatera text/bild i ett inlägg (ersätt filerna i Drive-mappen)
suspend fun updateDiaryEntryOnDrive(
    context: Context,
    driveService: Drive,
    folderId: String,
    newText: String,
    newImageUri: Uri?
): DiaryEntry? {
    // Hämta filerna i mappen
    val fileList = driveService.files().list()
        .setQ("'$folderId' in parents and trashed = false")
        .setFields("files(id, name, mimeType, webContentLink, webViewLink)")
        .execute()

    // Uppdatera/ersätt textfilen
    val textFileDrive = fileList.files.find { it.name == "entry.txt" }
    val tempText = File.createTempFile("diary", ".txt", context.cacheDir)
    tempText.writeText(newText)
    if (textFileDrive != null) {
        val textContent = FileContent("text/plain", tempText)
        driveService.files().update(textFileDrive.id, null, textContent).execute()
    } else {
        // Om ingen textfil finns, skapa ny
        val textMetadata = DriveFile()
        textMetadata.name = "entry.txt"
        textMetadata.parents = listOf(folderId)
        val textContent = FileContent("text/plain", tempText)
        driveService.files().create(textMetadata, textContent).execute()
    }
    tempText.delete()

    // Uppdatera/ersätt bildfilen
    var imageDriveUrl: String? = null
    val imageFileDrive = fileList.files.find { it.mimeType.startsWith("image") }
    if (newImageUri != null) {
        val inputStream = context.contentResolver.openInputStream(newImageUri)
        val tempImg = File.createTempFile("diaryimg", ".jpg", context.cacheDir)
        inputStream?.use { input ->
            tempImg.outputStream().use { output ->
                input.copyTo(output)
            }
        }
        if (imageFileDrive != null) {
            val imgContent = FileContent("image/jpeg", tempImg)
            val updatedImage = driveService.files().update(imageFileDrive.id, null, imgContent)
                .setFields("id,webContentLink,webViewLink")
                .execute()
            // Lägg till permission på den uppdaterade bilden
            val permission = com.google.api.services.drive.model.Permission()
            permission.type = "anyone"
            permission.role = "reader"
            driveService.permissions().create(updatedImage.id, permission).execute()
            imageDriveUrl = updatedImage.webContentLink ?: updatedImage.webViewLink
        } else {
            val imgMetadata = DriveFile()
            imgMetadata.name = "image.jpg"
            imgMetadata.parents = listOf(folderId)
            val imgContent = FileContent("image/jpeg", tempImg)
            val uploadedImage = driveService.files().create(imgMetadata, imgContent)
                .setFields("id,webContentLink,webViewLink")
                .execute()
            // Lägg till permission på den nya bilden
            val permission = com.google.api.services.drive.model.Permission()
            permission.type = "anyone"
            permission.role = "reader"
            driveService.permissions().create(uploadedImage.id, permission).execute()
            imageDriveUrl = uploadedImage.webContentLink ?: uploadedImage.webViewLink
        }
        tempImg.delete()
    } else if (imageFileDrive != null) {
        // Om ingen bild ska finnas längre: ta bort bildfilen
        driveService.files().delete(imageFileDrive.id).execute()
    }

    return DiaryEntry(
        id = folderId,
        text = newText,
        imageUrl = imageDriveUrl,
        createdAt = "" // Kan laddas om från Drive om du vill visa tiden
    )
}

// DELETE: Ta bort hela inläggets mapp från Drive
suspend fun deleteDiaryEntryFromDrive(
    driveService: Drive,
    folderId: String
) {
    driveService.files().delete(folderId).execute()
}

@Composable
fun DiaryDriveCrudScreen(navController: NavController) {
    val context = LocalContext.current
    val googleAccount = GoogleSignIn.getLastSignedInAccount(context)
    val driveService = remember(googleAccount) { googleAccount?.let { getDriveService(context, it) } }

    var diaryEntries by remember { mutableStateOf(listOf<DiaryEntry>()) }
    var newEntry by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var isSaving by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    var uploadError by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    // Redigera-dialog
    var editEntry by remember { mutableStateOf<DiaryEntry?>(null) }
    var editText by remember { mutableStateOf("") }
    var editImageUri by remember { mutableStateOf<Uri?>(null) }
    var showEditDialog by remember { mutableStateOf(false) }
    var editIsUploading by remember { mutableStateOf(false) }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }
    val editImagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        editImageUri = uri
    }

    // Ladda inlägg från Drive när driveService finns
    LaunchedEffect(driveService) {
        if (driveService != null) {
            isLoading = true
            try {
                diaryEntries = withContext(Dispatchers.IO) {
                    loadAllDiaryEntriesFromDrive(driveService)
                }
            } catch (e: Exception) {
                uploadError = "Kunde inte ladda inlägg: ${e.message}"
            }
            isLoading = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp)
    ) {
        Text(
            text = "Min Dagbok (Google Drive)",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(20.dp))
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = newEntry,
                onValueChange = { newEntry = it },
                placeholder = { Text("Skriv ditt dagboksinlägg här...") },
                textStyle = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
            )

            if (imageUri != null) {
                Image(
                    painter = rememberAsyncImagePainter(imageUri),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 10.dp),
                    contentScale = ContentScale.Crop
                )
            }

            if (uploadError != null) {
                Text(uploadError!!, color = MaterialTheme.colorScheme.error)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = { imagePickerLauncher.launch("image/*") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Välj Bild")
                }
                Button(
                    onClick = {
                        if (newEntry.isNotBlank() && driveService != null && !isSaving) {
                            isSaving = true
                            uploadError = null
                            scope.launch(Dispatchers.IO) {
                                try {
                                    val entry = saveDiaryEntryToDrive(context, driveService, newEntry, imageUri)
                                    if (entry != null) {
                                        diaryEntries = listOf(entry) + diaryEntries
                                        newEntry = ""
                                        imageUri = null
                                    }
                                } catch (e: Exception) {
                                    uploadError = "Kunde inte spara: ${e.message}"
                                }
                                isSaving = false
                            }
                        }
                    },
                    modifier = Modifier.weight(1f),
                    enabled = !isSaving
                ) {
                    Text(if (isSaving) "Sparar..." else "Spara inlägg")
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(diaryEntries) { entry ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(15.dp))
                            .padding(15.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            IconButton(onClick = {
                                editEntry = entry
                                editText = entry.text
                                editImageUri = null
                                showEditDialog = true
                            }) {
                                Icon(Icons.Default.Edit, contentDescription = "Redigera")
                            }
                            IconButton(onClick = {
                                if (driveService != null) {
                                    scope.launch(Dispatchers.IO) {
                                        try {
                                            deleteDiaryEntryFromDrive(driveService, entry.id)
                                            diaryEntries = diaryEntries.filter { it.id != entry.id }
                                        } catch (e: Exception) {
                                            uploadError = "Kunde inte ta bort: ${e.message}"
                                        }
                                    }
                                }
                            }) {
                                Icon(Icons.Default.Delete, contentDescription = "Ta bort")
                            }
                        }
                        Text(
                            entry.text,
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        if (!entry.imageUrl.isNullOrBlank()) {
                            Image(
                                painter = rememberAsyncImagePainter(entry.imageUrl),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(200.dp)
                                    .align(Alignment.CenterHorizontally)
                                    .padding(top = 10.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Text(
                            entry.createdAt,
                            color = MaterialTheme.colorScheme.outline,
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.align(Alignment.End)
                        )
                    }
                }
            }
        }
    }

    // Dialog för att redigera inlägg (text och bild)
    if (showEditDialog && editEntry != null && driveService != null) {
        AlertDialog(
            onDismissRequest = { showEditDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    if (!editIsUploading) {
                        editIsUploading = true
                        scope.launch(Dispatchers.IO) {
                            try {
                                val updated = updateDiaryEntryOnDrive(
                                    context,
                                    driveService,
                                    editEntry!!.id,
                                    editText,
                                    editImageUri
                                )
                                diaryEntries = diaryEntries.map {
                                    if (it.id == editEntry!!.id && updated != null) updated else it
                                }
                                showEditDialog = false
                            } catch (e: Exception) {
                                uploadError = "Kunde inte spara ändringar: ${e.message}"
                            }
                            editIsUploading = false
                        }
                    }
                }) {
                    Text(if (editIsUploading) "Sparar..." else "Spara")
                }
            },
            dismissButton = {
                TextButton(onClick = { showEditDialog = false }) {
                    Text("Avbryt")
                }
            },
            title = { Text("Redigera inlägg") },
            text = {
                Column {
                    OutlinedTextField(
                        value = editText,
                        onValueChange = { editText = it },
                        label = { Text("Text") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(8.dp))
                    if (editImageUri != null) {
                        Image(
                            painter = rememberAsyncImagePainter(editImageUri),
                            contentDescription = null,
                            modifier = Modifier
                                .size(200.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        TextButton(
                            onClick = { editImageUri = null },
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text("Ta bort bild")
                        }
                    }
                    TextButton(
                        onClick = { editImagePickerLauncher.launch("image/*") },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text("Välj ny bild")
                    }
                }
            }
        )
    }
}