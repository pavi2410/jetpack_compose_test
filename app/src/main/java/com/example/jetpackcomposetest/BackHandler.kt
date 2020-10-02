package com.example.jetpackcomposetest

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.onCommit
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticAmbientOf

val AmbientBackPressedDispatcher = staticAmbientOf<OnBackPressedDispatcherOwner?> { null }

private class ComposableBackHandler(enabled: Boolean) : OnBackPressedCallback(enabled) {
    lateinit var onBackPressed: () -> Unit

    override fun handleOnBackPressed() {
        onBackPressed()
    }
}

@Composable
fun backButtonHandler(
    enabled: Boolean = true,
    onBackPressed: () -> Unit
) {
    val dispatcher = (AmbientBackPressedDispatcher.current ?: return).onBackPressedDispatcher
    val handler = remember { ComposableBackHandler(enabled) }
    onCommit(dispatcher) {
        dispatcher.addCallback(handler)
        onDispose { handler.remove() }
    }
    onCommit(enabled) {
        handler.isEnabled = enabled
    }
    onCommit(onBackPressed) {
        handler.onBackPressed = onBackPressed
    }
}
