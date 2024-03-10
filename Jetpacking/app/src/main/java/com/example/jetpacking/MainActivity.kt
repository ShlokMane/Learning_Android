package com.example.jetpacking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacking.ui.theme.JetpackingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Box(modifier = Modifier
            .background(color = Color.Blue)
            .size(120.dp, 250.dp),
            contentAlignment = Alignment.Center) {

        }
        Box(modifier = Modifier
            .background(color = Color.Green)
            .size(80.dp, 100.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackingTheme {
        Greeting()
    }
}