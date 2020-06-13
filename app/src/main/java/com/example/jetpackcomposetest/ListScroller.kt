package com.example.jetpackcomposetest

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.core.drawShadow
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.ripple.ripple
import androidx.ui.text.font.FontFamily
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp

@Composable
fun Greeting(name: String) {
    Box(modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp).drawShadow(8.dp)) {
        Box(
            modifier = Modifier.height(64.dp).fillMaxWidth().clip(RoundedCornerShape(8.dp))
                .ripple(color = Color.Blue.copy(alpha = 0.8f)),
            backgroundColor = Color.Blue
        ) {
            Row(verticalGravity = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.width(8.dp).height(64.dp),
                    backgroundColor = Color.Blue.copy(alpha = 0.3f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = name,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }
    }
}

@Preview(showDecoration = true)
@Composable
fun ListScroller() {
    VerticalScroller {
        listOf("Android", "Hello World", "🤣😂", "Foo bar", "haha")
            .flatMap {
                listOf(it, it, it)
            }
            .shuffled()
            .forEach {
                Greeting(it)
            }
    }
}