package org.wikipedia.homeworks.homework08


import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.exampies.withText
import org.wikipedia.main.MainActivity

class ExploreTestScreen : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    private val numOfPage = 3

    @Test
    fun logoTest() {
        run {
            repeat(numOfPage) { page ->
                step("Проверяем отображение логотипа на странице $page") {
                    OnboardingScreen.slider.childAt<OnboardingPagerItem>(page) {
                        wikiLogo.isDisplayed()
                    }
                }
                step("Переходим на следующую страницу") {
                    OnboardingScreen.forwardButton.click()
                }
            }
        }
    }

    @Test
    fun primaryTitleTest() {
        run {
            repeat(numOfPage) { page ->
                step("Проверяем отображение заглавного текстового поля на странице $page") {
                    OnboardingScreen.slider.childAt<OnboardingPagerItem>(page) {
                        textTitle.isDisplayed()
                    }
                }
                step("Переходим на следующую страницу") {
                    OnboardingScreen.forwardButton.click()
                }
            }
        }
    }

    @Test
    fun secondaryTitleTest() {
        run {
            repeat(numOfPage) { page ->
                step("Проверяем отображение второго текстового поля на странице $page") {
                    OnboardingScreen.slider.childAt<OnboardingPagerItem>(page) {
                        secondTextTitle.isDisplayed()
                    }
                }
                step("Переходим на следующую страницу") {
                    OnboardingScreen.forwardButton.click()
                }
            }
        }
    }

    @Test
    fun addLanguageButtonTest() {
        run {
            step("Проверяем отображение кнопки 'Добавить или изменить язык'") {
                OnboardingScreen.slider.childAt<OnboardingPagerItem>(0) {
                    addLanguageButton.isDisplayed()
                }
            }
            step("Проверяем кликабельность кнопки 'Добавить или изменить язык'") {
                OnboardingScreen.slider.childAt<OnboardingPagerItem>(0) {
                    addLanguageButton.isClickable()
                }
            }
        }
    }

    @Test
    fun bottomButtonSkipTest() {
        run {
            step("Проверяем отображение кнопки 'Skip'") {
                OnboardingScreen.skipButton.isDisplayed()
            }

            step("Проверяем кликабельность кнопки 'Skip'") {
                OnboardingScreen.skipButton.isClickable()
            }

            step("Кликаем по кнопке 'Skip'") {
                OnboardingScreen.skipButton.click()
            }
        }
    }

    @Test
    fun pageIndicatorTest() {
        run {
            step("Проверяем наличие индикатора страниц") {
                OnboardingScreen.pageIndicator.isDisplayed()
            }
        }
    }

    @Test
    fun bottomButtonContinueTest() {
        run {
            step("Проверяем отображение кнопки 'Continue'") {
                OnboardingScreen.forwardButton.isDisplayed()
            }

            step("Проверяем кликабельность кнопки 'Continue'") {
                OnboardingScreen.forwardButton.isClickable()
            }

            step("Кликаем по кнопке 'Continue'") {
                OnboardingScreen.forwardButton.click()
            }
        }
    }

    @Test
    fun bottomButtonGetStartedTest() {
        run {
            step("Убеждаемся, что кнопки 'Get Started' нет на начальном экране") {
                OnboardingScreen.doneButton.isGone()
            }

            step("Делаем 3 клика для появления кнопки 'Get Started'") {
                repeat(numOfPage) {
                    OnboardingScreen.forwardButton.click()
                }
            }

            step("Проверяем отображение кнопки 'Get Started'") {
                OnboardingScreen.doneButton.isDisplayed()
            }

            step("Проверяем кликабельность кнопки 'Get Started'") {
                OnboardingScreen.doneButton.isClickable()
            }

            step("Кликаем по кнопке 'Get Started'") {
                OnboardingScreen.doneButton.click()
            }
        }
    }

    @Test
    fun addLanguageTest() {
        run {
            step("Проверяем отображение кнопки 'Add or edit language'") {
                OnboardingScreen.slider.childAt<OnboardingPagerItem>(0) {
                    addLanguageButton.isDisplayed()
                }
            }

            step("Кликаем на кнопку 'Add or edit language'") {
                OnboardingScreen.slider.childAt<OnboardingPagerItem>(0) {
                    addLanguageButton.click()
                }
            }

        }
    }

}

