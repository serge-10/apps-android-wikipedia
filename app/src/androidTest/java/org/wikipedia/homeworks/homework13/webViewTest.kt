package org.wikipedia.homeworks.homework13

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework19.Steps
import org.wikipedia.homeworks.homework19.steps
import org.wikipedia.main.MainActivity

class WebViewTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {

        run {
            steps{
                click(OnboardingScreen.skipButton, "Кнопка skip")}

        }
    }
    fun isVisible(item : BaseAssertions) {

        run {
            val steps = Steps(this)
            steps.click(OnboardingScreen.skipButton, "Кнопка skip")
        }
    }
}