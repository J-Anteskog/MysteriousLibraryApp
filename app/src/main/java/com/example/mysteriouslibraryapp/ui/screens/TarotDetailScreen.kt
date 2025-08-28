package com.example.mysteriouslibraryapp.ui.screens

import android.app.AlertDialog
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mysteriouslibraryapp.components.LanguageSwitcher
import com.example.mysteriouslibraryapp.model.TarotCard
import com.example.mysteriouslibraryapp.state.LanguageManager
import com.google.api.services.drive.Drive
import com.google.api.services.drive.model.File as DriveFile
import com.google.api.client.http.FileContent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

@Composable
fun TarotDetailScreen(
    navController: NavController,
    card: TarotCard?,
    languageManager: LanguageManager,
    driveService: Drive
) {
    val context = LocalContext.current
    var locale by remember { mutableStateOf(languageManager.currentLocale) }
    var userInterpretation by remember { mutableStateOf("") }
    var editInterpretation by remember { mutableStateOf("") }
    var isSaving by remember { mutableStateOf(false) }
    var saveMessage by remember { mutableStateOf<String?>(null) }
    var isLoadingInterpretation by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(languageManager.currentLocale) { locale = languageManager.currentLocale }

    if (card == null) {
        Box(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Kortet hittades inte",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        return
    }

    // Ladda användartolkning från Drive
    LaunchedEffect(card.id) {
        isLoadingInterpretation = true
        userInterpretation = withContext(Dispatchers.IO) {
            loadUserInterpretationFromDrive(driveService, card.id) ?: ""
        }
        editInterpretation = userInterpretation
        isLoadingInterpretation = false
    }

    val getMeaning: (String) -> String = { type ->
        when (type) {
            "upright" -> card.meaning[locale]?.upright ?: card.meaning["en"]?.upright.orEmpty()
            "reversed" -> card.meaning[locale]?.reversed ?: card.meaning["en"]?.reversed.orEmpty()
            else -> ""
        }
    }

    val getInterpretation: (String) -> String = { type ->
        when (type) {
            "upright" -> card.interpretation[locale]?.upright ?: card.interpretation["en"]?.upright.orEmpty()
            "reversed" -> card.interpretation[locale]?.reversed ?: card.interpretation["en"]?.reversed.orEmpty()
            else -> ""
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(card.name, style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.onBackground, modifier = Modifier.padding(bottom = 5.dp))
        Text(card.arcana, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onBackground, modifier = Modifier.padding(bottom = 20.dp))
        LanguageSwitcher(onLanguageChange = { newLocale -> languageManager.setLanguage(newLocale); locale = newLocale })

        Image(
            painter = painterResource(id = card.imageRes),
            contentDescription = card.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier.width(200.dp).height(350.dp).padding(bottom = 25.dp)
        )

        CardSection("Meaning Upright", getMeaning("upright"))
        CardSection("Meaning Reversed", getMeaning("reversed"))
        CardSection("Interpretation Upright", getInterpretation("upright"))
        CardSection("Interpretation Reversed", getInterpretation("reversed"))

        Spacer(Modifier.height(24.dp))
        Text("Din egen tolkning", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary, modifier = Modifier.align(Alignment.Start))

        if (isLoadingInterpretation) {
            CircularProgressIndicator()
        } else {
            OutlinedTextField(
                value = editInterpretation,
                onValueChange = { editInterpretation = it },
                placeholder = { Text("Skriv din egen tolkning här...") },
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
            )

            Row {
                Button(
                    onClick = {
                        isSaving = true
                        saveMessage = null
                        scope.launch {
                            withContext(Dispatchers.IO) { saveUserInterpretationToDrive(context, driveService, card.id, editInterpretation) }
                            userInterpretation = editInterpretation
                            isSaving = false
                            saveMessage = "Tolkning sparad!"
                        }
                    },
                    modifier = Modifier.padding(top = 10.dp),
                    enabled = !isSaving
                ) { Text(if (isSaving) "Sparar..." else "Spara din tolkning") }

                Spacer(Modifier.width(8.dp))

                // DELETE-knapp med bekräftelsedialog
                Button(
                    onClick = {
                        AlertDialog.Builder(context)
                            .setTitle("Bekräfta borttagning")
                            .setMessage("Är du säker på att du vill radera denna tolkning?")
                            .setPositiveButton("Ja") { _, _ ->
                                scope.launch {
                                    withContext(Dispatchers.IO) { deleteUserInterpretationFromDrive(driveService, card.id) }
                                    userInterpretation = ""
                                    editInterpretation = ""
                                    saveMessage = "Tolkning raderad!"
                                }
                            }
                            .setNegativeButton("Nej", null)
                            .show()
                    },
                    modifier = Modifier.padding(top = 10.dp)
                ) { Text("Radera") }
            }

            if (saveMessage != null) {
                Text(saveMessage!!, color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(top = 8.dp))
            }

            if (userInterpretation.isNotBlank()) {
                CardSection("Senast sparade tolkning", userInterpretation)
            }
        }
    }
}

@Composable
fun CardSection(title: String, content: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(15.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline)
            .padding(bottom = 10.dp)
    ) {
        Text(title, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(bottom = 5.dp))
        Text(content, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurface, lineHeight = MaterialTheme.typography.bodyLarge.lineHeight)
    }
}

// --- DRIVELAGRING: CRUD ---

suspend fun saveUserInterpretationToDrive(context: Context, driveService: Drive, cardId: String, userText: String) {
    val folderId = getOrCreateFolder(driveService)
    val noteName = "my_interpretation_$cardId.txt"
    val existingFiles = driveService.files().list().setQ("name='$noteName' and '$folderId' in parents and trashed=false").setFields("files(id)").execute()

    val tempFile = File.createTempFile("note", ".txt", context.cacheDir)
    tempFile.writeText(userText)
    val content = FileContent("text/plain", tempFile)

    if (existingFiles.files.isNotEmpty()) {
        driveService.files().update(existingFiles.files[0].id, null, content).execute()
    } else {
        val fileMetadata = DriveFile().apply { name = noteName; parents = listOf(folderId) }
        driveService.files().create(fileMetadata, content).execute()
    }
    tempFile.delete()
}

suspend fun loadUserInterpretationFromDrive(driveService: Drive, cardId: String): String? {
    val folderId = getOrCreateFolder(driveService) ?: return null
    val noteName = "my_interpretation_$cardId.txt"
    val files = driveService.files().list().setQ("name='$noteName' and '$folderId' in parents and trashed=false").setFields("files(id)").execute()
    if (files.files.isEmpty()) return null
    val input = driveService.files().get(files.files[0].id).executeMediaAsInputStream()
    return input.bufferedReader().readText()
}

suspend fun deleteUserInterpretationFromDrive(driveService: Drive, cardId: String) {
    val folderId = getOrCreateFolder(driveService) ?: return
    val noteName = "my_interpretation_$cardId.txt"
    val files = driveService.files().list().setQ("name='$noteName' and '$folderId' in parents and trashed=false").setFields("files(id)").execute()
    if (files.files.isNotEmpty()) {
        driveService.files().delete(files.files[0].id).execute()
    }
}

private suspend fun getOrCreateFolder(driveService: Drive): String? {
    val folderList = driveService.files().list()
        .setQ("mimeType='application/vnd.google-apps.folder' and name='TarotNotes' and trashed=false")
        .setFields("files(id)").execute()
    return if (folderList.files.isNotEmpty()) folderList.files[0].id
    else {
        val folder = DriveFile().apply { name = "TarotNotes"; mimeType = "application/vnd.google-apps.folder" }
        driveService.files().create(folder).setFields("id").execute().id
    }
}
