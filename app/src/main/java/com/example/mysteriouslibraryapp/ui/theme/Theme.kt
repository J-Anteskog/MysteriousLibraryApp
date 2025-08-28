package com.example.mysteriouslibraryapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Gold,
    onPrimary = OnPrimaryDark,
    secondary = GoldDark,
    background = DeepNavy,
    surface = DarkSurface,
    onBackground = Gold,
    onSurface = Gold,
    outline = OutlineGold
    // lägg till fler om du vill!
)

@Composable
fun MysteriousLibraryAppTheme(
    darkTheme: Boolean = true, // Tvinga mörkt läge!
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}