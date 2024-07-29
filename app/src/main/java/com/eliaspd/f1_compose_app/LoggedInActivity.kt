package com.eliaspd.f1_compose_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LoggedInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val username = intent.getStringExtra("USERNAME")
        setContent {
            LoggedInScreen(username) { logOut() }
        }
    }

    private fun logOut() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}

@Composable
fun LoggedInScreen(username: String?, onLogOut: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome, $username!",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "You are logged in and ready to explore!",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(onClick = onLogOut) {
            Text("Log out")
        }
    }
}

