package org.wikipedia.homeworks.homework10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUIAutomatorTest: TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkImageIsView(){
        run{
           OnboardingUISccren.image.isDisabled()
        }
    }
}