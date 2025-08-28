package com.example.mysteriouslibraryapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mysteriouslibraryapp.state.LanguageManager

@Composable
fun WelcomeScreen(navController: NavController, languageManager: LanguageManager) {
    var isSwedish by remember { mutableStateOf(true) }

    fun toggleLanguage() {
        isSwedish = !isSwedish
    }

    fun navigateToLogin() {
        navController.navigate("login")
    }

    fun navigateAsGuest() {
        navController.navigate("home")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("EN", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.labelLarge)
            Switch(
                checked = isSwedish,
                onCheckedChange = { toggleLanguage() },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                    uncheckedThumbColor = MaterialTheme.colorScheme.outline,
                    checkedTrackColor = MaterialTheme.colorScheme.primary,
                    uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant
                )
            )
            Text("SV", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.labelLarge)
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = if (isSwedish) "Välkommen till Mysterious Library" else "Welcome to the Mysterious Library",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = if (isSwedish) "Den här appen är tänkt att fungera som ett redskap, där man enkelt kan söka kort/runa man vill ha en tolkning av" else
                    "This app is intended to function as a tool, where you can easily search for the card/rune you want an interpretation of.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Text(
                text = if (isSwedish) "Välj ett alternativ" else "Choose an option",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Button(
                onClick = { navigateToLogin() },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 15.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = if (isSwedish) "Logga in / Registrera" else "Login / Signup",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Button(
                onClick = { navigateAsGuest() },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 15.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = if (isSwedish) "Fortsätt som gäst" else "Continue as Guest",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}