package com.example.mysteriouslibraryapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mysteriouslibraryapp.components.LanguageSwitcher
import com.example.mysteriouslibraryapp.model.Rune
import com.example.mysteriouslibraryapp.state.LanguageManager

@Composable
fun SearchScreen(
    navController: NavController,
    runes: List<Rune>,
    languageManager: LanguageManager
) {
    var query by remember { mutableStateOf(TextFieldValue("")) }
    var currentLocale by remember { mutableStateOf(languageManager.currentLocale) }

    LaunchedEffect(languageManager.currentLocale) {
        currentLocale = languageManager.currentLocale
    }

    val filteredRunes = runes.filter { rune ->
        rune.name.lowercase().contains(query.text.lowercase()) ||
                rune.meaning[currentLocale]?.lowercase()?.contains(query.text.lowercase()) == true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        LanguageSwitcher(
            onLanguageChange = { newLocale -> languageManager.setLanguage(newLocale) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Info box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(15.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = "Sök bland runorna",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        // Sökfält
        TextField(
            value = query,
            onValueChange = { query = it },
            placeholder = { Text("Sök runor...", color = MaterialTheme.colorScheme.outline) },
            colors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.primary,
                unfocusedTextColor = MaterialTheme.colorScheme.primary,
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        filteredRunes.forEach { rune ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate("runeDetail/${rune.id}") }
                    .padding(vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val imagePainter = rune.imageResId?.let { painterResource(id = it) }
                Image(
                    painter = imagePainter
                        ?: painterResource(id = com.example.mysteriouslibraryapp.R.drawable.ic_launcher_foreground),
                    contentDescription = rune.name,
                    modifier = Modifier.size(30.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = rune.name,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            HorizontalDivider(
                Modifier,
                DividerDefaults.Thickness,
                color = MaterialTheme.colorScheme.primary
            )
        }

        if (filteredRunes.isEmpty()) {
            Text(
                text = "Inga runor hittades",
                color = MaterialTheme.colorScheme.outline,
                style = MaterialTheme.typography.bodyMedium.copy(fontStyle = FontStyle.Italic),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}