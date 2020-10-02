package com.example.jetpackcomposetest

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

@Preview(showDecoration = true)
@Composable
fun VRCC() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "🥳",
            fontSize = 40.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Congratulations! Your device is VR compatible",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        listOf(
            DetailModel("Android Version", Icons.Default.Android, true),
            DetailModel("Accelerometer", Icons.Default.AccessAlarm, false),
            DetailModel("Compass", Icons.Default.CompassCalibration, true),
            DetailModel("Gyroscope", Icons.Default.Gamepad, false),
            DetailModel("Screen Size", Icons.Default.ScreenLockPortrait, true),
            DetailModel("RAM", Icons.Default.Memory, true)
        )
            .forEach {
                Detail(it)
            }
    }
}

data class DetailModel(
    val name: String,
    val icon: VectorAsset,
    val pass: Boolean
)

@Composable
fun Detail(model: DetailModel) {
    Box(modifier = Modifier.padding(vertical = 4.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth().height(48.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = CenterVertically,
                modifier = Modifier
                    .background(
                        color = Color(0x4DBBDEFB),
                        shape = RoundedCornerShape(
                            topRightPercent = 50,
                            bottomRightPercent = 50
                        )
                    )
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
            ) {
                Icon(
                    asset = model.icon,
                    tint = Color(0xFF1976D2),
                    modifier = Modifier.width(32.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = model.name,
                    fontSize = 24.sp,
                    color = Color(0xFF1976D2)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Row(
                verticalAlignment = CenterVertically,
                modifier = Modifier
                    .background(
                        color = Color(0x4DBBDEFB),
                        shape = RoundedCornerShape(
                            topLeftPercent = 50,
                            bottomLeftPercent = 50
                        )
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxHeight()
            ) {

                if (model.pass)
                    Icon(
                        asset = Icons.Default.Check,
                        tint = Color.Green,
                        modifier = Modifier.width(32.dp)
                    )
                else
                    Icon(
                        asset = Icons.Default.Cancel,
                        tint = Color.Red,
                        modifier = Modifier.width(32.dp)
                    )
            }
        }
    }
}
