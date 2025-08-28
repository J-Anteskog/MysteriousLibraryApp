package com.example.mysteriouslibraryapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mysteriouslibraryapp.model.TarotCard
import androidx.compose.material3.*
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun TarotSearchScreen(
    navController: NavController,
    tarotCards: List<TarotCard>
) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    val locale = "en"

    val filteredCards = tarotCards.filter { card ->
        val query = searchQuery.text.lowercase()
        card.name.lowercase().contains(query) ||
                (card.meaning[locale]?.upright?.lowercase()?.contains(query) == true) ||
                (card.meaning[locale]?.reversed?.lowercase()?.contains(query) == true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(15.dp)
    ) {
        Text(
            text = "Tarot Search",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search Tarot", color = MaterialTheme.colorScheme.outline) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.onBackground,
                unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
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
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 20.dp)
        ) {
            items(filteredCards) { card ->
                TarotCardItem(card = card, onClick = {
                    navController.navigate("tarotDetail/${card.id}")
                })
            }
        }
    }
}

@Composable
fun TarotCardItem(card: TarotCard, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .background(MaterialTheme.colorScheme.surface)
            .border(1.dp, MaterialTheme.colorScheme.outline)
            .clickable { onClick() }
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = card.imageRes),
            contentDescription = card.name,
            modifier = Modifier
                .width(50.dp)
                .height(80.dp)
                .padding(end = 15.dp),
            contentScale = ContentScale.Fit
        )

        Text(
            text = card.name,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleMedium
        )
    }
}