package com.example.bookapp.data.repository

import com.example.bookapp.data.dao.BookDao
import com.example.bookapp.data.model.Book
import kotlinx.coroutines.flow.Flow

class BookRepository(private val bookDao: BookDao) {

    fun getAllBooks(): Flow<List<Book>> = bookDao.getAllBooks()

    fun getBook(bookId: Int): Flow<Book> = bookDao.getBook(bookId)

    suspend fun insertBook(book: Book) {
        bookDao.insertBook(book)
    }

    suspend fun updateBook(book: Book) {
        bookDao.updateBook(book)
    }

    suspend fun deleteBook(bookId: Int) {
        bookDao.deleteBook(bookId)
    }
}