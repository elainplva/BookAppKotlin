package com.example.bookapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bookapp.data.dao.BookDao
import com.example.bookapp.data.model.Book

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}