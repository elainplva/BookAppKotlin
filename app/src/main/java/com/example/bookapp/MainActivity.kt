package com.example.bookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import com.example.bookapp.navigation.Navigation
import com.example.bookapp.ui.theme.BookAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookAppTheme {
                Navigation()
            }
        }
    }
}


@Composable
fun BookAppTheme() {
    val nav = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavBar(nav) }
    ) { padding ->
        NavHost(
            navController = nav,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Screen.Home.route) { HomeScreen(nav) }
            composable(Screen.Login.route) { LoginScreen(nav) }
            composable(Screen.Favourites.route) { FavouritesScreen(nav) }
            composable(Screen.Settings.route) { SettingsScreen() }
            composable(Screen.Details.route) { backStack ->
                val id = backStack.arguments?.getString("bookId")!!.toInt()
                DetailsScreen(id, nav)
            }
        }
    }
}
