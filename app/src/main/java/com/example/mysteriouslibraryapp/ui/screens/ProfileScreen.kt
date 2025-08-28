package com.example.mysteriouslibraryapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mysteriouslibraryapp.ui.components.ProfileInputField

@Composable
fun ProfileScreen(navController: NavController) {
    var starSign by remember { mutableStateOf("") }
    var favoriteCard by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Min Profil",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        ProfileInputField(
            label = "Stjärntecken",
            value = starSign,
            onValueChange = { starSign = it }
        )

        ProfileInputField(
            label = "Favoritkort",
            value = favoriteCard,
            onValueChange = { favoriteCard = it }
        )

        ProfileInputField(
            label = "Anteckningar",
            value = notes,
            onValueChange = { notes = it },
            singleLine = false,
            maxLines = 5
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { /* Spara profiländringar */ },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Spara", color = MaterialTheme.colorScheme.onPrimary)
        }
    }
}