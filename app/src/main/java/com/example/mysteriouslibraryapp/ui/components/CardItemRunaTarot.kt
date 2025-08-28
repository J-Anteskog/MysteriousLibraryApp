package com.example.mysteriouslibraryapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun CardItem(
    name: String,
    imageResId: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2B2B2B), RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFF444444), RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = name,
            modifier = Modifier.size(width = 50.dp, height = 80.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = name,
            color = Color(0xFFE0E0E0),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
