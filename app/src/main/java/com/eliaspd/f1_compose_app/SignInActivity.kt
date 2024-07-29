package com.eliaspd.f1_compose_app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.eliaspd.f1_compose_app.ui.theme.MyAppTheme

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                SignInScreen { username, password ->
                    validateLogin(username, password)
                }
            }
        }
    }

    private fun validateLogin(username: String, password: String) {
        val validUsers = mapOf(
            "1234" to "0000",
            "user1" to "password1",
            "user2" to "password2"
        )

        if (validUsers[username] == password) {
            startActivity(Intent(this, LoggedInActivity::class.java).apply {
                putExtra("USERNAME", username)
            })
        } else {
            Toast.makeText(this, "Invalid login", Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun SignInScreen(onLogin: (String, String) -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BasicTextField(
            value = username,
            onValueChange = { username = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(16.dp)
                ) {
                    if (username.isEmpty()) Text("Enter your username")
                    innerTextField()
                }
            }
        )
        BasicTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            visualTransformation = PasswordVisualTransformation(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(16.dp)
                ) {
                    if (password.isEmpty()) Text("Enter your password")
                    innerTextField()
                }
            }
        )
        Button(onClick = { onLogin(username, password) }) {
            Text("Log in")
        }
    }
}
