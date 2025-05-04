package org.wikipedia.homeworks.homework26

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.kautomator.system.UiSystem.click
import com.kaspersky.components.kautomator.system.UiSystem.sleep
import com.kaspersky.kaspresso.internal.systemscreen.DataUsageSettingsScreen.pressBack
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.AllureSupportTest
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.main.MainActivity


class TestWithScenario : AllureSupportTest() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test() = run {
        actions {
            click(OnboardingScreen.skipBtn)
            ExploreScreenNew.featuredArticleItemByID(0) {
                click(this.articleTitle)
            }
            val saveBnt = device.uiDevice.findObject(UiSelector().textContains("Save"))
            click(saveBnt)
            sleep(1000L)
            pressBack()
            ExploreScreenNew.inTheNewsItem {
                tabNewsItem(1) {
                    click(this)
                    pressBack()
                }
            }
            repeat(4) {
                swipeUp()
            }
            ExploreScreenNew.featuredArticleItemByID(1) {
                click(this.articleTitle)
            }
            click(saveBnt)
            sleep(1000L)
            pressBack()
            val savedBnt = device.uiDevice.findObject(UiSelector().textContains("Saved"))
            click(savedBnt)
        }
    }

    override fun actions(function: () -> Unit) {

    }
}