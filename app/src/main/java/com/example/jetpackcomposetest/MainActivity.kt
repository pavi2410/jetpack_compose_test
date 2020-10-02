package com.example.jetpackcomposetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Providers(AmbientBackPressedDispatcher provides this) {
                    Navigator(this::finish)
                }
            }
        }
    }
}

enum class Screen {
    Home, ListScroller, SimpleList, MarkDownParser, VRCC, TopHype, BoxModel
}

object NavStatus {
    var currentScreen = mutableStateOf(Screen.Home)
}

fun navigateTo(destination: Screen) {
    NavStatus.currentScreen.value = destination
}

@Composable
fun Navigator(closeApp: () -> Unit) {
    val (showExitDialog, setShowExitDialog) = remember { mutableStateOf(false) }

    backButtonHandler {
        if (NavStatus.currentScreen.value == Screen.Home) {
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
            onDismissRequest = { setShowExitDialog(false) }
        )
    }

    when (NavStatus.currentScreen.value) {
        Screen.Home -> Home()
        Screen.ListScroller -> ListScroller()
        Screen.SimpleList -> SimpleList()
        Screen.MarkDownParser -> MarkDownParser()
        Screen.VRCC -> VRCC()
        Screen.TopHype -> TopHype()
        Screen.BoxModel -> BoxModel()
    }
}

@Composable
fun Home() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
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