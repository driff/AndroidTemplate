package com.driff.android.module_template.presentation.welcome

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WelcomeScreen(welcomeMessage: String) {
    Text(text =  welcomeMessage,
        modifier = Modifier.testTag(WelcomeScreenTags.WelcomeText.name)
    )
}

@Preview
@Composable
fun PreviewMessageCard() {
    WelcomeScreen("Android")
}