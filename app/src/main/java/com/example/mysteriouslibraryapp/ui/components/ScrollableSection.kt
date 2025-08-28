package com.example.mysteriouslibraryapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ScrollableSection(title: String, content: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2B2B2B), RoundedCornerShape(10.dp))
            .border(1.dp, Color(0xFF444444), RoundedCornerShape(10.dp))
            .padding(15.dp)
            .padding(bottom = 10.dp)
            .padding(vertical = 5.dp)
    ) {
        Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF6A0DAD))
        Spacer(modifier = Modifier.height(5.dp))
        Text(content, fontSize = 16.sp, color = Color(0xFFE0E0E0), lineHeight = 24.sp)
    }
}
