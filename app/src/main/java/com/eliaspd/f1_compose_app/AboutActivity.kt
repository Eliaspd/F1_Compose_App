package com.eliaspd.f1_compose_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eliaspd.f1_compose_app.ui.theme.MyAppTheme

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                AboutScreen { navigateToSignIn() }
            }
        }
    }

    private fun navigateToSignIn() {
        startActivity(Intent(this, SignInActivity::class.java))
    }
}

@Composable
fun AboutScreen(onSignIn: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "F1",
            fontSize = 32.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "F1 is the coolest Motorsport in the world. It is held almost all year around on different race tracks!",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        BasicTextField(
            value = "Write your thoughts here...",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(bottom = 16.dp)
        )
        Button(onClick = onSignIn) {
            Text("Sign in")
        }
    }
}
