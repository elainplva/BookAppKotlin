package com.example.bookapp.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Settings") })
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { /* Handle Edit Profile */ } // TODO: Implement navigation
                    .padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Edit Profile")
                Text(text = "Edit Profile", modifier = Modifier.padding(start = 16.dp))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { /* Handle Privacy */ } // TODO: Implement navigation
                    .padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Privacy")
                Text(text = "Privacy", modifier = Modifier.padding(start = 16.dp))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { /* Handle Log Out */ } // TODO: Implement navigation
                    .padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Log Out")
                Text(text = "Log Out", modifier = Modifier.padding(start = 16.dp))
            }
        }
    }
}