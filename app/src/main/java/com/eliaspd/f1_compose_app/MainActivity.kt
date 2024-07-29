package com.eliaspd.f1_compose_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eliaspd.f1_compose_app.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                MainScreen { navigateToAbout() }
            }
        }
    }

    private fun navigateToAbout() {
        startActivity(Intent(this, AboutActivity::class.java))
    }
}

@Composable
fun MainScreen(onNavigateToAbout: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome!",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(onClick = onNavigateToAbout) {
            Text("About")
        }
    }
}
