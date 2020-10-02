package com.example.jetpackcomposetest

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Preview
@Composable
fun BoxModel() {
    Box(
        modifier = Modifier // applies from outside (left) to inside (right)
            .size(100.dp)
            .background(Color.Red).padding(4.dp)   // margin
            .border(1.dp, Color.Black)             // border
            .background(Color.Green).padding(8.dp) // padding
    ) {
        Box(modifier = Modifier.background(Color.Blue).fillMaxSize())
    }
}

@Preview
@Composable
fun BoxModel2() {
    Button(onClick = {},
        modifier = Modifier
            .background(Color.Red).padding(4.dp)   // margin
            .border(1.dp, Color.Black)             // border
            .background(Color.Green).padding(8.dp) // padding
    ) {
        Text("hello")
    }
}