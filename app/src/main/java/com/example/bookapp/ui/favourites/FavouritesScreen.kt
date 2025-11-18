package com.example.bookapp.ui.favourites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bookapp.data.model.Book
import com.example.bookapp.navigation.Screen
import com.example.bookapp.ui.viewmodel.BookViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouritesScreen(navController: NavController, viewModel: BookViewModel = viewModel()) {
    val books by viewModel.allBooks.collectAsState(initial = emptyList())
    val favouriteBooks = books.filter { it.isFavourite }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Favourites") })
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(favouriteBooks) { book ->
                BookItem(book = book, navController = navController)
            }
        }
    }
}

@Composable
fun BookItem(book: Book, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate(Screen.Details.create(book.id)) }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = book.title, fontWeight = FontWeight.Bold)
                Text(text = book.author)
            }
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favourite Icon",
            )
        }
    }
}
