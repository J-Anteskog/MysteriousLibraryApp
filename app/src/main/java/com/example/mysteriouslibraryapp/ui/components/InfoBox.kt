package com.example.mysteriouslibraryapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun InfoBox(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF22223B), RoundedCornerShape(10.dp))
            .border(1.dp, Color(0xFFE0C097), RoundedCornerShape(10.dp))
            .padding(15.dp)
            .padding(bottom = 10.dp)
    ) {
        Text(
            text = text,
            color = Color(0xFFE0C097),
            textAlign = TextAlign.Center,
            fontSize = 15.sp
        )
    }
}
