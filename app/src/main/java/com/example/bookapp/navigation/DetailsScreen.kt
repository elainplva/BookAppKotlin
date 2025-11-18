package com.example.bookapp.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
fun DetailsScreen(bookId: Int, nav: NavController, viewModel: BookViewModel = viewModel()) {
    val book by viewModel.getBook(bookId).collectAsState(initial = null)
    book?.let {
        Column(Modifier.padding(16.dp)) {
            Text(it.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Author: " + it.author)
            Spacer(Modifier.height(20.dp))
            Text(it.synopsis)
            Row {
                IconButton({ viewModel.toggleFavourite(it) }) {
                    Icon(
                        if (it.isFavourite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        null
                    )
                }
                if (viewModel.isLoggedIn.collectAsState().value) {
                    Button({ viewModel.pickPdf(it) }) { Text("Upload PDF") }
                }
                if (it.pdfPath != null) {
                    Button({ viewModel.downloadPdf(it.pdfPath!!) }) { Text("Download PDF") }
                }
            }
            Spacer(Modifier.height(16.dp))
            Text("Notes")
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.height(200.dp).fillMaxWidth()
            )
        }
    }
}
