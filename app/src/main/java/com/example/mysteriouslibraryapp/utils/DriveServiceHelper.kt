import android.content.Context
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.drive.Drive
import com.google.api.services.drive.DriveScopes
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import java.util.Collections

fun getDriveService(context: Context, account: GoogleSignInAccount): Drive {
    val credential: GoogleAccountCredential = GoogleAccountCredential.usingOAuth2(
        context,
        Collections.singleton(DriveScopes.DRIVE_FILE)
    )
    credential.selectedAccountName = account.email  // använd e-post som identifierare

    val transport = GoogleNetHttpTransport.newTrustedTransport()
    val jsonFactory = GsonFactory.getDefaultInstance()

    return Drive.Builder(
        transport,
        jsonFactory,
        credential
    )
        .setApplicationName("MysteriousLibraryApp")
        .build()
}
