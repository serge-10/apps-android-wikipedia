package org.wikipedia.homeworks.homework29

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.kautomator.system.UiSystem.click
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.BuildConfig
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.main.MainActivity


class SuccessfulTest : TestCase() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun successfulTest() {
        run {
            BuildConfig.HOME_WORK
//            BuildConfig.alphaLogin
            val login = Users.alphaLogin
            val password = Credentials.getPassword(login)
            namedSteps {
                click(OnboardingScreen.skipButton)
                ExploreScreenNew.searchCardViewItem {
                    searchText.hasText("Search Wikipedia")
                }
            }
        }
    }
}