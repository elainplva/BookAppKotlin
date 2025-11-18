package com.example.bookapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bookapp.data.repository.AuthRepository

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    fun login(email: String, pass: String): Boolean {
        return repository.login(email, pass)
    }

    fun register(email: String, pass: String): Boolean {
        return repository.register(email, pass)
    }
}