package com.example.mysteriouslibraryapp.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class LanguageManager {
    var currentLocale by mutableStateOf("sv")
        private set

    fun setLanguage(newLang: String) {
        currentLocale = newLang
    }
}