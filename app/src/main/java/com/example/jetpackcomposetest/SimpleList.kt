package com.example.jetpackcomposetest

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun SimpleList() {
    Column {
        repeat(10) {
            Text(it.toString())
        }
    }
}