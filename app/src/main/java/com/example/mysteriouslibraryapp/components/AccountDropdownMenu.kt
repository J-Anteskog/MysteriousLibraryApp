package com.example.mysteriouslibraryapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

@Composable
fun AccountDropdownMenu(
    onProfileClick: () -> Unit,
    onDiaryClick: () -> Unit,
    onTarotClick: () -> Unit,
    onRuneClick: () -> Unit,
    onOracleClick: () -> Unit,
    onLogout: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val user = FirebaseAuth.getInstance().currentUser

    if (user != null && !user.isAnonymous) {
        Box(modifier = modifier) {
            IconButton(onClick = { expanded = true }) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Konto",
                    tint = Color(0xFFE0E0E0)
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(user.email ?: "Profil") },
                    onClick = {
                        expanded = false
                        onProfileClick()
                    }
                )
                DropdownMenuItem(
                    text = { Text("Dagbok") },
                    onClick = {
                        expanded = false
                        onDiaryClick()
                    }
                )
                DropdownMenuItem(
                    text = { Text("Tarot") },
                    onClick = {
                        expanded = false
                        onTarotClick()
                    }
                )
                DropdownMenuItem(
                    text = { Text("Runor") },
                    onClick = {
                        expanded = false
                        onRuneClick()
                    }
                )
                DropdownMenuItem(
                    text = { Text("Orakel") },
                    onClick = {
                        expanded = false
                        onOracleClick()
                    }
                )
                HorizontalDivider()
                DropdownMenuItem(
                    text = { Text("Logga ut") },
                    onClick = {
                        expanded = false
                        coroutineScope.launch {
                            FirebaseAuth.getInstance().signOut()
                            onLogout()
                        }
                    }
                )
            }
        }
    }
}