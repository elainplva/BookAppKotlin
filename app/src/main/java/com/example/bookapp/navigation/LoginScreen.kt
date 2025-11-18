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
fun LoginScreen(nav: NavController, authVM: AuthViewModel = viewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(Modifier.padding(16.dp)) {
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value = password, onValueChange = { password = it }, label = { Text("Password") })
        Button(onClick = { authVM.login(email, password); nav.navigate(Screen.Home.route) }) {
            Text("Login")
        }
        Button(onClick = { authVM.register(email, password) }) {
            Text("Register")
        }
    }
}
