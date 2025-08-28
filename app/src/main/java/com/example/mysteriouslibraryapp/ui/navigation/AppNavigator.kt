package com.example.mysteriouslibraryapp.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mysteriouslibraryapp.model.TarotCards
import com.example.mysteriouslibraryapp.model.runeList
import com.example.mysteriouslibraryapp.state.LanguageManager
import com.example.mysteriouslibraryapp.ui.MainScaffold
import com.example.mysteriouslibraryapp.ui.screens.*
import com.google.android.gms.auth.api.signin.GoogleSignIn

@Composable
fun AppNavigator() {
    val navController: NavHostController = rememberNavController()
    val languageManager = remember { LanguageManager() }
    val runes = runeList

    MainScaffold(navController = navController) {
        NavHost(navController = navController, startDestination = "welcome") {

            // Huvudskärmar
            composable("welcome") { WelcomeScreen(navController, languageManager) }
            composable("home") { HomeScreen(navController) }
            composable("login") { LoginScreen(navController) }
            composable("profile") { ProfileScreen(navController) }
            composable("diary") { DiaryDriveCrudScreen(navController) }

            // Rune
            composable("search") {
                SearchScreen(
                    navController,
                    runes = runes,
                    languageManager = languageManager
                )
            }
            composable("runeSearch") {
                RuneSearchScreen(
                    navController,
                    runes = runes,
                    languageManager = languageManager
                )
            }
            composable("runeDetail/{runeId}") { backStackEntry ->
                val runeId = backStackEntry.arguments?.getString("runeId")
                val rune = runes.find { it.id == runeId }
                if (rune != null) {
                    RuneDetailScreen(navController, rune, languageManager)
                }
            }

            // Tarot
            composable("tarotSearch") {
                TarotSearchScreen(
                    navController,
                    tarotCards = TarotCards.cards
                )
            }
            composable("tarotDetail/{cardId}") { backStackEntry ->
                val cardId = backStackEntry.arguments?.getString("cardId")
                val card = TarotCards.cards.find { it.id == cardId }
                if (card != null) {
                    val context = LocalContext.current
                    val account = GoogleSignIn.getLastSignedInAccount(context)

                    val driveService = remember(account) {
                        account?.let { getDriveService(context, it) }
                    }

                    if (driveService != null) {
                        TarotDetailScreen(
                            navController = navController,
                            card = card,
                            languageManager = languageManager,
                            driveService = driveService // garanterat icke-null här
                        )
                    } else {
                        // 👇 fallback om användaren inte är inloggad
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Du måste logga in med Google för att spara tolkningar.",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }
        }
    }
}
