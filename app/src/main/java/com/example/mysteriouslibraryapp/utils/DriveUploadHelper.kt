package com.example.mysteriouslibraryapp.utils



import android.content.Context
import android.net.Uri
import com.google.api.services.drive.Drive
import com.google.api.services.drive.model.File
import com.google.api.client.http.FileContent
suspend fun uploadImageToDrive(
    context: Context,
    driveService: Drive,
    imageUri: Uri
): String? {
    val inputStream = context.contentResolver.openInputStream(imageUri)
    val tempFile = java.io.File.createTempFile("upload", ".jpg", context.cacheDir)
    inputStream?.use { input ->
        tempFile.outputStream().use { output ->
            input.copyTo(output)
        }
    }
    val metadata = File().apply { name = "dagbokbild_${System.currentTimeMillis()}.jpg" }
    val mediaContent = FileContent("image/jpeg", tempFile)
    val uploadedFile = driveService.files().create(metadata, mediaContent)
        .setFields("id,webContentLink,webViewLink")
        .execute()
    tempFile.delete()
    return uploadedFile.webViewLink
}