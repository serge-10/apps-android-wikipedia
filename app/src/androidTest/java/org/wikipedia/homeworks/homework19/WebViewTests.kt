package org.wikipedia.homeworks.homework19

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.components.kautomator.system.UiSystem.sleep
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.FeaturedArticleItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework13.ArticleViewScreen
import org.wikipedia.main.MainActivity


class WebViewTests : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run {
            steps {
                disableNetwork(device)
                enableNetwork(device)
                setOrientationLeft(device)
                click(OnboardingScreen.skipButton, "Кнопка skip")
                setOrientationRight(device)

                isVisible(
                    ExploreScreen.items.childWith<FeaturedArticleItem> {
                        withDescendant { withText("Featured article") }
                    },
                    "Находим статью 'Featured article'"
                )

                hasAnyText(
                    ExploreScreen.items.childWith<FeaturedArticleItem> {
                        withDescendant { withText("Featured article") }
                    }.title,
                    "Featured article title"
                )

                sleep(5000)
                setOrientationNatural(device)

                click(
                    ExploreScreen.items.childAt<FeaturedArticleItem>(3).title,
                    "The 2nd article"
                )

                isVisible(
                    ExploreScreen.items.childAt<FeaturedArticleItem>(3).title,
                    "Заголовок статьи"
                )

                ArticleViewScreen {
                    webView {
                        withElement(Locator.ID, "References") {
                            hasText("References")
                        }
                    }
                }
            }
        }
    }
}
