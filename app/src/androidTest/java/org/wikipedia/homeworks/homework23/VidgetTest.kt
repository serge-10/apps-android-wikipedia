package org.wikipedia.homeworks.homework23


import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.kautomator.system.UiSystem.click
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework20.NewOnboardingScreen
import org.wikipedia.main.MainActivity

class VidgetTest: TestCase() {
    @GET:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWitWidget(){
        namedSteps{
            click(NewOnboardingScreen.skipButton)

            ExploreScreenWithWidget.searchWidget{
                isVisible(voiceIcon)

            }
        }
    }
}