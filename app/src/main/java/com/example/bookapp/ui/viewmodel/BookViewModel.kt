package com.example.bookapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookapp.data.model.Book
import com.example.bookapp.data.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BookViewModel(private val repository: BookRepository) : ViewModel() {

    val allBooks: Flow<List<Book>> = repository.getAllBooks()

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn = _isLoggedIn.asStateFlow()

    fun getBook(bookId: Int): Flow<Book> {
        return repository.getBook(bookId)
    }

    fun toggleFavourite(book: Book) {
        viewModelScope.launch {
            val updatedBook = book.copy(isFavourite = !book.isFavourite)
            repository.updateBook(updatedBook)
        }
    }

    fun pickPdf(book: Book) {
        // Implement PDF picking logic here
    }

    fun downloadPdf(pdfPath: String) {
        // Implement PDF downloading logic here
    }
}