package com.example.jetpackcomposetest

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.VerticalGradient
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

@Preview(heightDp = 760, widthDp = 360)
@Composable
fun NeoPlayer() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = VerticalGradient(
                    listOf(Color(0xffdfeafd), Color(0xffecf3fc)),
                    startY = 0.0f,
                    endY = 100.0f
                )
            )
            .padding(start = 32.dp, end = 32.dp, bottom = 32.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            NeoButton(icon = Icons.Default.ArrowBack)
            Text(text = "PLAYING NOW", color = Color.Gray)
            NeoButton(icon = Icons.Default.Menu)
        }
        Box(
            modifier = Modifier
                .size(256.dp)
                .drawShadow(elevation = 32.dp, shape = CircleShape)
                .background(
                    brush = VerticalGradient(
                        listOf(Color(0xffbeaade), Color(0xffce96c7), Color(0xffdb7b93)),
                        startY = 0.0f,
                        endY = 100.0f
                    )
                )
                .border(width = 8.dp, color = Color(0xffc5d3e3), shape = CircleShape)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Lose It",
                color = Color.DarkGray,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Flume ft. Vic Mensa", color = Color.Gray)
        }
        NeoProgress(start = "1:21", end = "3:46")
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            NeoButton(icon = Icons.Default.FastRewind, size = 72.dp)
            NeoButton(
                icon = Icons.Default.Pause,
                size = 72.dp,
                backgroundColor = Color(0xff87a4ff),
                iconColor = Color(0xfff9feff),
                borderColor = Color(0xff7991f1)
            )
            NeoButton(icon = Icons.Default.FastForward, size = 72.dp)
        }
    }
}

//@Preview(showDecoration = true)
@Composable
fun NeoList() {

}

@Composable
fun NeoButton(
    icon: VectorAsset,
    size: Dp = 56.dp,
    backgroundColor: Color = Color.White,
    iconColor: Color = Color(0xffa6b1cb),
    borderColor: Color = Color(0xffeef8ff)
) {
    Button(
        onClick = {},
        shape = CircleShape,
        backgroundColor = backgroundColor,
        modifier = Modifier
            .size(size)
            .drawShadow(elevation = 16.dp, shape = CircleShape)
            .border(width = 2.dp, color = borderColor, shape = CircleShape)
    ) {
        Icon(asset = icon, tint = iconColor)
    }
}

@Composable
fun NeoProgress(start: String, end: String) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = start, color = Color.Gray)
            Text(text = end, color = Color.Gray)
        }
        Slider(
            value = start / end,
            onValueChange = {},
            thumbColor = Color(0xff87a4ff),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

data class Time(val min: Int, val sec: Int)

fun String.toTime() = with(this.split(":")) {
    Time(this[0].toInt(), this[1].toInt())
}

fun Time.toInt() = 60 * min + sec

operator fun String.div(final: String) =
    this.toTime().toInt().toFloat() / final.toTime().toInt()
