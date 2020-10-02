package com.example.jetpackcomposetest

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.viewinterop.AndroidView
import androidx.ui.tooling.preview.Preview


@Preview(showDecoration = true)
@Composable
fun MarkDownParser() {
    val mdRaw = """
   # Hello World
     
   **I'm your boss**
   
   ![haha](//hello.com)
   """.trimIndent()

    val ctx = ContextAmbient.current

    val webView = webview(ctx)

    val (md, setMd) = remember { mutableStateOf(TextFieldValue(mdRaw)) }
    val (html, setHtml) = remember { mutableStateOf(TextFieldValue(parseMd(mdRaw))) }

    webView.loadData(html.text, "text/html", "utf-8")

    Column {
        CodeEditor(
            value = md,
            onValueChange = {
                setMd(it)
                setHtml(TextFieldValue(parseMd(it.text)))
            })
        Divider()
        CodeEditor(value = html, onValueChange = { setHtml(it) })
        Divider()
        AndroidView(viewBlock = { webView })
    }
}