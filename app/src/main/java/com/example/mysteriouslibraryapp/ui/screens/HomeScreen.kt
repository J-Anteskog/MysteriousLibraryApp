package com.example.mysteriouslibraryapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mysteriouslibraryapp.ui.MainScaffold

@Composable
fun HomeScreen(navController: NavHostController) {

        var isSwedish by remember { mutableStateOf(true) }

        fun toggleLanguage() {
            isSwedish = !isSwedish
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
                Text("EN", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.labelLarge)
                Switch(
                    checked = isSwedish,
                    onCheckedChange = { toggleLanguage() },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.onBackground,
                        uncheckedThumbColor = MaterialTheme.colorScheme.outline,
                        checkedTrackColor = MaterialTheme.colorScheme.primary,
                        uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                )
                Text("SV", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.labelLarge)
            }

            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = if (isSwedish) "Välkommen till Mysterious Library!" else "Welcome to Mysterious Library!",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(bottom = 10.dp)
                )

                Text(
                    text = if (isSwedish) "Välj en kategori att utforska:" else "Choose a category to explore:",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(bottom = 30.dp)
                )

                val buttonModifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 15.dp)
                val buttonColors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)

                Button(
                    onClick = { navController.navigate("runeSearch") },
                    colors = buttonColors,
                    modifier = buttonModifier,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        if (isSwedish) "Runor" else "Runes",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                Button(
                    onClick = { navController.navigate("tarotSearch") },
                    colors = buttonColors,
                    modifier = buttonModifier,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        if (isSwedish) "Tarot" else "Tarot",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                Button(
                    onClick = {
                        Toast.makeText(
                            navController.context,
                            if (isSwedish) "Orakel kommer snart!" else "Oracle coming soon!",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    colors = buttonColors,
                    modifier = buttonModifier,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        if (isSwedish) "Orakel" else "Oracle",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }
