package com.example.bookapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Login : Screen("login")
    object Favourites : Screen("favourites")
    object Settings : Screen("settings")
    object Details : Screen("details/{bookId}") {
        fun create(bookId: Int) = "details/$bookId"
    }
}