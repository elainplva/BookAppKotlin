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
