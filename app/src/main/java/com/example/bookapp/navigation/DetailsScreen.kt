package com.example.bookapp.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bookapp.ui.viewmodel.BookViewModel

@Composable
fun DetailsScreen(
    bookId: Int,
    navController: NavController,
    viewModel: BookViewModel = viewModel()
) {
    val book by viewModel.getBook(bookId).collectAsState(initial = null)
    book?.let { book ->
        Column(Modifier.padding(16.dp)) {
            Text(book.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Author: " + book.author)
            Spacer(Modifier.height(20.dp))
            Text(book.synopsis)
            Row {
                IconButton({ viewModel.toggleFavourite(book) }) {
                    Icon(
                        if (book.isFavourite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = null
                    )
                }
                if (viewModel.isLoggedIn.collectAsState().value) {
                    Button({ viewModel.pickPdf(book) }) { Text("Upload PDF") }
                }
                if (book.pdfPath != null) {
                    Button({ viewModel.downloadPdf(book.pdfPath!!) }) { Text("Download PDF") }
                }
            }
            Spacer(Modifier.height(16.dp))
            Text("Notes")
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
        }
    }
}
