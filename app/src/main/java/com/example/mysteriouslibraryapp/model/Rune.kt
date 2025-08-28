package com.example.mysteriouslibraryapp.model

data class Rune(
    val id: String,
    val name: String,
    val imageResId: Int?, // Använd nullable om vissa saknar bild
    val meaning: Map<String, String>, // "en"->"Meaning...", "sv"->"Betydelse..."
    val interpretation: Map<String, String>
)