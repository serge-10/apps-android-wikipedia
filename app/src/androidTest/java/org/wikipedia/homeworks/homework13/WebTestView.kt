package org.wikipedia.homeworks.homework13

import android.widget.PopupWindow
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.kautomator.system.UiSystem.click
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.TopReadCardViewItem
import org.wikipedia.homeworks.homework07.WikiCardViewItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class WebTestView : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run {
            step("Пропускаем онбординг") {
                OnboardingScreen.skipButton.click()
            }
            step("Кликаем на статью") {
                ExploreScreen.items.childWith<TopReadCardViewItem> {
                    withDescendant { withText("Top read") }
                }.perform {
                    wikiCardViewItems.childAt<WikiCardViewItem>(2) {
                        cardItemTitle.click()
                    }
                }
            }
            step("Скроллим до элемента с id 'References'") {
                ArticleViewScreen {
                    webView {
                        withElement(Locator.ID, "References") {
                            scroll()
                            hasText("References")
                        }
                    }
                }
            }
            step("Нажимаем на ссылку '5'") {
                ArticleViewScreen {
                    withElement(Locator.XPATH, "//a[@class='reference-link' and text()='5']") {
                        scroll()
                        click()
                    }
                }
            }
            step("Проверить соответствие текста заголовка и номера в строке (5.)") {
                PopUpWindowViewScreen.pager.childAt<PopUpWindowItems>(0) {
                    referenceId.isVisible()
                    referenceId.containsText("5")
                }
            }
            step("Закрываем всплывающее окно") {
                device.uiDevice.pressBack()
            }
            step("Найти вторую ссылку с CSS классом mw-redirect и нажать на неё") {
                ArticleViewScreen {
                    webView {
                        withElement(Locator.CSS_SELECTOR, "a.mw-redirect:nth-of-type(2)") {
                            scroll()
                            click()
                        }
                    }
                }
            }
            step("Нажать на нём кнопку 'Read article'") {
                flakySafely { var timeoutMs = 10000 }
                PreviewContainer.readArticleButton.click()
            }
            step("Скроллим до элемента с id 'References'") {
                ArticleViewScreen {
                    webView {
                        withElement(Locator.ID, "References") {
                            scroll()
                            hasText("References")
                        }
                    }
                }
            }
        }
    }

    private fun scroll() {
        TODO("Not yet implemented")
    }
}
