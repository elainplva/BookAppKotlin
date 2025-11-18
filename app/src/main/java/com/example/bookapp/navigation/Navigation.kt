package com.example.bookapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookapp.ui.home.HomeScreen
import com.example.bookapp.ui.login.LoginScreen
import com.example.bookapp.ui.favourites.FavouritesScreen
import com.example.bookapp.ui.settings.SettingsScreen
import com.example.bookapp.ui.details.DetailsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.Favourites.route) {
            FavouritesScreen(navController = navController)
        }
        composable(Screen.Settings.route) {
            SettingsScreen(navController = navController)
        }
        composable(Screen.Details.route) {
            DetailsScreen()
        }
    }
}