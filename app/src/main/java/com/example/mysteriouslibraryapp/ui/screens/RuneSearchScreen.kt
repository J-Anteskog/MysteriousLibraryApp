package com.example.mysteriouslibraryapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mysteriouslibraryapp.components.LanguageSwitcher
import com.example.mysteriouslibraryapp.model.Rune
import com.example.mysteriouslibraryapp.state.LanguageManager

@Composable
fun RuneSearchScreen(
    navController: NavController,
    runes: List<Rune>,
    languageManager: LanguageManager
) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    val locale = languageManager.currentLocale

    val filteredRunes = runes.filter { rune ->
        val query = searchQuery.text.lowercase()
        rune.name.lowercase().contains(query) ||
                (rune.meaning[locale]?.lowercase()?.contains(query) == true) ||
                (rune.interpretation[locale]?.lowercase()?.contains(query) == true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp)
    ) {
        Text(
            text = "Rune Search",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        )

        LanguageSwitcher(onLanguageChange = languageManager::setLanguage)

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search Runes", color = MaterialTheme.colorScheme.outline) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.primary,
                unfocusedTextColor = MaterialTheme.colorScheme.primary,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedPlaceholderColor = MaterialTheme.colorScheme.outline,
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.outline
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredRunes) { rune ->
                RuneItem(rune = rune, locale = locale) {
                    navController.navigate("runeDetail/${rune.id}")
                }
            }

            if (filteredRunes.isEmpty()) {
                item {
                    Text(
                        text = "No runes found",
                        color = MaterialTheme.colorScheme.outline,
                        style = MaterialTheme.typography.bodyLarge.copy(fontStyle = androidx.compose.ui.text.font.FontStyle.Italic),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun RuneItem(
    rune: Rune,
    locale: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .background(MaterialTheme.colorScheme.surface)
            .border(1.dp, MaterialTheme.colorScheme.primary)
            .clickable { onClick() }
            .padding(12.dp)
    ) {
        Column {
            Text(
                text = rune.name,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium
            )
            val meaning = rune.meaning[locale] ?: rune.meaning["en"].orEmpty()
            Text(
                text = meaning,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}