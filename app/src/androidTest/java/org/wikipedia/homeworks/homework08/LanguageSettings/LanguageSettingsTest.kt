//package org.wikipedia.homeworks.homework08.LanguageSettings
//
//import androidx.test.ext.junit.rules.ActivityScenarioRule
//import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
//import org.junit.Rule
//import org.junit.Test
//import org.wikipedia.main.MainActivity
//
//class LanguageSettingsTest : TestCase() {
//
//    @get:Rule
//    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
//        ActivityScenarioRule(MainActivity::class.java)
//
//    private val numOfPage = 3
//
//    // Тест на отображение кнопки для добавления языка
//    @Test
//    fun addLanguageButtonTest() {
//        run {
//            step("Проверяем отображение кнопки 'Добавить или изменить язык'") {
//                MainScreen.languageSettingsButton.isDisplayed()
//            }
//
//            step("Проверяем кликабельность кнопки 'Добавить или изменить язык'") {
//                MainScreen.languageSettingsButton.isClickable()
//            }
//        }
//    }
//
//    // Тест на проверку отображения языков
//    @Test
//    fun languageListTest() {
//        run {
//            step("Проверяем отображение списка доступных языков") {
//                MainScreen.languageList.isDisplayed()
//            }
//
//            step("Проверяем наличие хотя бы одного языка в списке") {
//                MainScreen.languageList.childAt<LanguageItem>(0) {
//                    text.isDisplayed()
//                }
//            }
//        }
//    }
//
//    // Тест на добавление нового языка
//    @Test
//    fun addLanguageTest() {
//        run {
//            step("Проверяем отображение кнопки 'Add or edit language'") {
//                MainScreen.languageSettingsButton.isDisplayed()
//            }
//
//            step("Кликаем на кнопку 'Add or edit language'") {
//                MainScreen.languageSettingsButton.click()
//            }
//
//            step("Добавляем новый язык в настройках") {
//                LanguageSettingsScreen.addLanguageButton.click()
//                LanguageSettingsScreen.languageNameField.typeText("Español")
//                LanguageSettingsScreen.languageCodeField.typeText("es")
//                LanguageSettingsScreen.saveButton.click()
//            }
//
//            step("Проверяем, что язык добавлен") {
//                MainScreen.languageList.childAt<LanguageItem>(0) {
//                    text.hasText("Español")
//                }
//            }
//        }
//    }
//
//    // Тест на смену языка интерфейса
//    @Test
//    fun changeLanguageTest() {
//        run {
//            step("Выбираем новый язык из списка") {
//                MainScreen.languageList.childAt<LanguageItem>(0) {
//                    text.click()
//                }
//            }
//
//            step("Проверяем, что интерфейс изменился на новый язык") {
//                MainScreen.textOnPage.hasText("Bienvenido")
//            }
//        }
//    }
//
//    // Тест на проверку кнопки 'Skip'
//    @Test
//    fun skipButtonTest() {
//        run {
//            step("Проверяем отображение кнопки 'Skip'") {
//                MainScreen.skipButton.isDisplayed()
//            }
//
//            step("Проверяем кликабельность кнопки 'Skip'") {
//                MainScreen.skipButton.isClickable()
//            }
//
//            step("Кликаем по кнопке 'Skip'") {
//                MainScreen.skipButton.click()
//            }
//        }
//    }
//
//    // Тест на проверку кнопки 'Continue'
//    @Test
//    fun continueButtonTest() {
//        run {
//            step("Проверяем отображение кнопки 'Continue'") {
//                MainScreen.continueButton.isDisplayed()
//            }
//
//            step("Проверяем кликабельность кнопки 'Continue'") {
//                MainScreen.continueButton.isClickable()
//            }
//
//            step("Кликаем по кнопке 'Continue'") {
//                MainScreen.continueButton.click()
//            }
//        }
//    }
//}
//
