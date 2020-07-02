package com.example.jetpackcomposetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.*
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.material.AlertDialog
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.lightColorPalette
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(colors = lightColorPalette()) {
                Providers(AmbientBackPressedDispatcher provides this) {
                    Navigator(this::finish)
                }
            }
        }
    }
}

enum class Screen {
    Home, ListScroller, MyScreen, MarkDownParser, VRCC, TopHype
}

object NavStatus {
    var currentScreen by mutableStateOf(Screen.Home)
}

fun navigateTo(destination: Screen) {
    NavStatus.currentScreen = destination
}

@Composable
fun Navigator(closeApp: () -> Unit) {
    val (showExitDialog, setShowExitDialog) = state { false }

    backButtonHandler {
        if (NavStatus.currentScreen == Screen.Home) {
            setShowExitDialog(true)
        } else {
            navigateTo(Screen.Home)
        }
    }

    if (showExitDialog) {
        AlertDialog(
            text = {
                Text("Do you want to really quit???")
            },
            confirmButton = {
                Button(
                    modifier = Modifier.padding(16.dp),
                    onClick = {
                        setShowExitDialog(false)
                        closeApp()
                    }
                ) {
                    Text(text = "OK")
                }
            },
            onCloseRequest = { setShowExitDialog(false) }
        )
    }

    when (NavStatus.currentScreen) {
        Screen.Home -> Home()
        Screen.ListScroller -> ListScroller()
        Screen.MyScreen -> MyScreen()
        Screen.MarkDownParser -> MarkDownParser()
        Screen.VRCC -> VRCC()
        Screen.TopHype -> TopHype()
    }
}

@Composable
fun Home() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalGravity = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Screen.values().filter { it != Screen.Home }.forEach {
            Button(
                modifier = Modifier.padding(16.dp).size(160.dp),
                onClick = { navigateTo(it) }
            ) {
                Text(text = it.name)
            }
        }
    }
}