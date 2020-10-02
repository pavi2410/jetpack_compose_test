package com.example.jetpackcomposetest

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

@Composable
fun Greeting(name: String) {
    val roundedShape = RoundedCornerShape(8.dp)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(64.dp)
            .padding(8.dp)
            .fillMaxWidth()
            .drawShadow(16.dp, roundedShape)
            .background(color = Color.Blue, shape = roundedShape)
            .clip(roundedShape)
    ) {
        Box(Modifier.width(8.dp).height(48.dp).background(Color.Green))
        Spacer(Modifier.width(8.dp))
        Text(
            text = name,
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.White.copy(alpha = 0.9f)
        )
    }
}

@Preview(showDecoration = true)
@Composable
fun ListScroller() {
    ScrollableColumn {
        listOf("Android Dev", "Hello World", "🤣😂", "Foo bar", "Jetpack Compose")
            .flatMap { listOf(it, it) }
            .take(10)
            .shuffled()
            .forEach {
                Greeting(it)
            }
    }
}