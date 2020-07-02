package com.example.jetpackcomposetest

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.Card
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.Divider
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowBack
import androidx.ui.material.icons.filled.Person
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp

//@Preview(showDecoration = true)
@Composable
fun TopHype() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.padding(8.dp)) {
            Icon(
                asset = Icons.Default.Person,
                modifier = Modifier.size(48.dp)
                    .drawBackground(Color.Yellow, shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text("TopHype", fontWeight = FontWeight.Bold)
                Text("@tophype", color = Color.DarkGray)
            }
        }
        Spacer(modifier = Modifier.height(4.dp))

        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            Text("14K Likes")
            Text("200 Followers")
            Text("16 Posts")
        }

        Spacer(modifier = Modifier.height(4.dp))

        Card(elevation = 4.dp, modifier = Modifier.fillMaxSize()) {
            Column {
                Text("hello")
                Text("world")
            }
        }
    }
}

@Preview(showDecoration = true)
@Composable
fun Profile() {
    Column {
        Icon(asset = Icons.Default.ArrowBack, modifier = Modifier.padding(16.dp))
        Divider()
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                asset = Icons.Default.Person,
                modifier = Modifier.size(48.dp)
                    .drawBackground(Color.Yellow, shape = CircleShape)
            )

            Column(horizontalGravity = Alignment.End) {
                Text("TopHype", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Text("@tophype", color = Color.DarkGray)
            }
        }
        Divider()
        Row(modifier = Modifier.padding(16.dp)) {
            Text("Followers : ")
            Text("1", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(1.dp))
            Text("Following : ")
            Text("2", fontWeight = FontWeight.Bold)

        }
        Divider()
        Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(text = "FOLLOW")
        }
        Divider()
        Box(gravity = ContentGravity.TopCenter, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            CircularProgressIndicator(progress = 0.7f)
        }
    }
}