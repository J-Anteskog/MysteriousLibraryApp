package com.example.mysteriouslibraryapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mysteriouslibraryapp.R
import com.example.mysteriouslibraryapp.model.Rune
import com.example.mysteriouslibraryapp.state.LanguageManager
import com.example.mysteriouslibraryapp.components.LanguageSwitcher

@Composable
fun RuneDetailScreen(
    navController: NavController,
    rune: Rune?,
    languageManager: LanguageManager
) {
    val scrollState = rememberScrollState()

    if (rune == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Rune not found", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodyLarge)
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = rune.name,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        LanguageSwitcher(onLanguageChange = languageManager::setLanguage)

        Spacer(modifier = Modifier.height(10.dp))

        val imagePainter = rune.imageResId
            ?.let { painterResource(id = it) }
            ?: painterResource(R.drawable.ic_launcher_foreground)

        Image(
            painter = imagePainter,
            contentDescription = rune.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Meaning",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Text(
            text = rune.meaning[languageManager.currentLocale] ?: rune.meaning["en"].orEmpty(),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
            lineHeight = MaterialTheme.typography.bodyLarge.lineHeight
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Interpretation",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Text(
            text = rune.interpretation[languageManager.currentLocale] ?: rune.interpretation["en"].orEmpty(),
            style = MaterialTheme.typography.bodyLarge.copy(fontStyle = FontStyle.Italic),
            color = MaterialTheme.colorScheme.primary,
            lineHeight = MaterialTheme.typography.bodyLarge.lineHeight
        )
    }
}