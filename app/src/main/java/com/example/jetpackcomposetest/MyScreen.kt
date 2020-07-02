package com.example.jetpackcomposetest

import androidx.compose.Composable
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentColorAmbient
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.tooling.preview.Preview

@Composable
fun MyScreen() {
    Column {
        repeat(10) {
            Text(it.toString())
        }
    }
}