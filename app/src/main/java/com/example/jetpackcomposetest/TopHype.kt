package com.example.jetpackcomposetest

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

@Preview(showDecoration = true)
@Composable
fun TopHype() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.padding(8.dp)) {
            Icon(
                asset = Icons.Default.Person,
                modifier = Modifier.size(48.dp)
                    .background(Color.Yellow, shape = CircleShape)
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
                    .background(Color.Yellow, shape = CircleShape)
            )

            Column(horizontalAlignment = Alignment.End) {
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
        Box(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            CircularProgressIndicator(progress = 0.7f)
        }
    }
}