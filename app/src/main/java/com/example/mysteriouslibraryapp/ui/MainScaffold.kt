package com.example.mysteriouslibraryapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(
    navController: NavHostController,
    content: @Composable () -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }
    val user = FirebaseAuth.getInstance().currentUser

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Mysterious Library",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                actions = {
                    IconButton(onClick = { menuExpanded = true }) {
                        Icon(Icons.Default.Menu, contentDescription = "Meny", tint = MaterialTheme.colorScheme.onPrimary)
                    }
                    DropdownMenu(
                        expanded = menuExpanded,
                        onDismissRequest = { menuExpanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Dagbok") },
                            onClick = {
                                if (navController.currentDestination?.route != "diary") {
                                    navController.navigate("diary")
                                }
                                menuExpanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Profil") },
                            onClick = {
                                if (navController.currentDestination?.route != "profile") {
                                    navController.navigate("profile")
                                }
                                menuExpanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Tarot") },
                            onClick = {
                                if (navController.currentDestination?.route != "tarotSearch") {
                                    navController.navigate("tarotSearch")
                                }
                                menuExpanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Runor") },
                            onClick = {
                                if (navController.currentDestination?.route != "runeSearch") {
                                    navController.navigate("runeSearch")
                                }
                                menuExpanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Orakel") },
                            onClick = {
                                // Byt till rätt route om du har en orakel-screen, annars ta bort denna rad
                                // navController.navigate("oracleSearch")
                                menuExpanded = false
                            }
                        )
                        HorizontalDivider()
                        if (user != null && !user.isAnonymous) {
                            DropdownMenuItem(
                                text = { Text("Logga ut") },
                                onClick = {
                                    FirebaseAuth.getInstance().signOut()
                                    navController.navigate("login") {
                                        popUpTo(0) { inclusive = true }
                                    }
                                    menuExpanded = false
                                }
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}