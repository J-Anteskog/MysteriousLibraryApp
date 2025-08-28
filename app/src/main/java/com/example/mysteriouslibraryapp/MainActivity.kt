package com.example.mysteriouslibraryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.mysteriouslibraryapp.ui.theme.MysteriousLibraryAppTheme
import com.google.firebase.FirebaseApp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initiera Firebase
        FirebaseApp.initializeApp(this)

        setContent {
            MysteriousLibraryAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    // Kör navigationen här
                    AppNavigator()
                }
            }
        }
    }
}

