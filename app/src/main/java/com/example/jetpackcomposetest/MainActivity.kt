package com.example.jetpackcomposetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.padding
import androidx.ui.material.AlertDialog
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Navigator()
            }
        }
    }
}

enum class Screen {
    Home, ListScroller, MyScreen, MarkDownParser, VRCC
}

@Composable
fun Navigator() {
    val (currentScreen, setCurrentScreen) = state { Screen.Home }
    val (showExitDialog, setShowExitDialog) = state { false }

    backButtonHandler(onBackPressed = {
        if (currentScreen == Screen.Home) {
            setShowExitDialog(true)
        } else {
            setCurrentScreen(Screen.Home)
        }
    })

    if (showExitDialog) {
        AlertDialog(
            text = {
                Text("Do you want to really quit???")
            },
            confirmButton = {
                Button(
                    modifier = Modifier.padding(16.dp),
                    onClick = { setShowExitDialog(false) }
                ) {
                    Text(text = "OK")
                }
            },
            onCloseRequest = { setShowExitDialog(false) }
        )
    }

    when (currentScreen) {
        Screen.Home -> Home(setCurrentScreen)
        Screen.ListScroller -> ListScroller()
        Screen.MyScreen -> MyScreen()
        Screen.MarkDownParser -> MarkDownParser()
        Screen.VRCC -> VRCC()
    }
}

@Composable
fun Home(setCurrentScreen: (Screen) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalGravity = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Screen.values().filter { it != Screen.Home }.forEach {
            Button(
                modifier = Modifier.padding(16.dp),
                onClick = { setCurrentScreen(it) }
            ) {
                Text(text = it.name)
            }
        }
    }
}