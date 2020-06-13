package com.example.jetpackcomposetest

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Alignment.Companion.CenterVertically
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.drawBackground
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.VectorAsset
import androidx.ui.graphics.vector.addPathNodes
import androidx.ui.graphics.vector.path
import androidx.ui.layout.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.*
import androidx.ui.material.icons.lazyMaterialIcon
import androidx.ui.material.icons.materialPath
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import java.util.*

@Preview(showDecoration = true)
@Composable
fun VRCC() {
    Column(
        horizontalGravity = Alignment.CenterHorizontally,
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
                verticalGravity = CenterVertically,
                modifier = Modifier
                    .drawBackground(
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
                    .weight(weight = 1f)
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
                verticalGravity = CenterVertically,
                modifier = Modifier
                    .drawBackground(
                        color = Color(0x4DBBDEFB),
                        shape = RoundedCornerShape(
                            topLeftPercent = 50,
                            bottomLeftPercent = 50
                        )
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxHeight()
            ) {
                val cancelIcon by lazyMaterialIcon {
                    materialPath {
                        addPathNodes("M19,6.41L17.59,5 12,10.59 6.41,5 5,6.41 10.59,12 5,17.59 6.41,19 12,13.41 17.59,19 19,17.59 13.41,12z")
                    }
                }

                if (model.pass)
                    Icon(
                        asset = Icons.Default.Check,
                        tint = Color.Green,
                        modifier = Modifier.width(32.dp)
                    )
                else
                    Icon(
                        asset = Icons.Default.Cancel,
//                        asset = cancelIcon,
                        tint = Color.Red,
                        modifier = Modifier.width(32.dp)
                    )
            }
        }
    }
}
