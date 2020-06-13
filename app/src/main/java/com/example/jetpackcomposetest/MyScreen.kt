package com.example.jetpackcomposetest

import androidx.compose.Composable
import androidx.ui.foundation.Text
import androidx.ui.layout.Column

@Composable
fun MyScreen() {
    Column {
        repeat(10) {
            Text(it.toString())
        }
    }
}