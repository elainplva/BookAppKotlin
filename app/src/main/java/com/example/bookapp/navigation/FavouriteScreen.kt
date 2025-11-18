package com.example.bookapp.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import com.example.bookapp.navigation.Navigation
import com.example.bookapp.ui.theme.FavouritesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FavouritesScreen {
                Navigation()
            }
        }
    }
}

@Composable
fun FavouritesScreen(nav: NavController, viewModel: BookViewModel = viewModel()) {
    val favourites by viewModel.favourites.collectAsState(initial = emptyList())
    LazyColumn {
        items(favourites) { book ->
            BookCard(book) { nav.navigate(Screen.Details.create(book.id)) }
        }
    }
}
