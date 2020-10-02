package com.example.jetpackcomposetest

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.ui.tooling.preview.Preview

@Preview
@Composable
fun ConfettiScreen() {
    Button(onClick = {}) {
        Text("More Confetti")
    }
}


@Composable
fun Confetti() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(color = Color.Red)
    }
}