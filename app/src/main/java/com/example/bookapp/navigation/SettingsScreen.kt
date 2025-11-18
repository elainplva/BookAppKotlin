package com.example.bookapp.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookapp.ui.theme.BookAppTheme
import com.example.bookapp.ui.viewmodel.AuthViewModel


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
fun SettingsScreen(authVM: AuthViewModel = viewModel()) {
    Column(Modifier.padding(16.dp)) {
        Button({ authVM.logout() }) {
            Text("Logout")
        }
        Button({ authVM.scheduleCleanupWorker() }) {
            Text("Run Background Cleanup")
        }
    }
}

private fun AuthViewModel.scheduleCleanupWorker() {
    TODO("Not yet implemented")
}

private fun AuthViewModel.logout() {
    TODO("Not yet implemented")
}
