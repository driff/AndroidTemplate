package com.driff.android.module_template

import android.os.Build
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.driff.android.module_template.presentation.welcome.WelcomeScreen
import com.driff.android.module_template.presentation.welcome.WelcomeScreenTags
import com.driff.android.module_template.ui.theme.AndroidModuleTemplateTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WelcomeViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun welcomeScreenMessageShouldBeDisplayed() {
        composeTestRule.mainClock.autoAdvance = true
        composeTestRule.setContent {
            AndroidModuleTemplateTheme {
                WelcomeScreen(welcomeMessage = "Hello World")
            }
        }
        composeTestRule.onNodeWithTag(WelcomeScreenTags.WelcomeText.name).assertIsDisplayed()
    }

}