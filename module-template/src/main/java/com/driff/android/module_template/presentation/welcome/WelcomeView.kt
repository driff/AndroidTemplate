package com.driff.android.module_template.presentation.welcome

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WelcomeScreen(welcomeMessage: String) {
    Text(text =  welcomeMessage)
}

@Preview
@Composable
fun PreviewMessageCard() {
    WelcomeScreen("Android")
}