package org.wikipedia.homeworks.homework11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity
import java.util.Locale
//
//class DeviceTestInTheNews : TestCase() {
//
//    @get:Rule
//    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
//
//    @Before
//    fun setup (){
//        device.network.toggleWiFi(false)
//    }
//
//    @Test
//    fun inTheNewsDeviceTest() {
//        before {
//            // Setup code (if needed)
//        }.after {
//            device.network.toggleWiFi(true)
//            device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
//            device.language.switchInApp(Locale.ENGLISH)
//        }.run {
//            step("Поворачиваем экран и проверяем ориентацию") {
//                device.exploit.rotate()
//                flakySafely(timeoutMs = 5000) {
//                    Assert.assertFalse(
//                        "Ожидалась портретная ориентация",
//                        device.uiDevice.isNaturalOrientation
//                    )
//                }
//            }
//            step("Выключите экран, включите его и убедитесь, что кнопка «Пропустить» отображается") {
//                device.uiDevice.sleep()
//                flakySafely(timeoutMs = 5000) {
//                    device.uiDevice.wakeUp()
//                    device.uiDevice.waitForIdle()
//                    OnboardingScreen.skipButton.isDisplayed()
//                }
//            }
//            step("Выйти из онбординга") {
//                OnboardingScreen.skipButton.click()
//            }
//            step("Сверните приложение, снова откройте его и убедитесь, что отображается 'In the news'") {
//                device.uiDevice.pressHome()
//                Thread.sleep(1000) // Consider replacing with flakySafely
//                device.uiDevice.pressRecentApps()
//                Thread.sleep(1000) // Consider replacing with flakySafely
//                device.uiDevice.findObject(UiSelector().text("Wikipedia")).click()//
//                flakySafely {
//                    ExploreScreen.items.childWith<InTheNewsCarditem> {
//                        withDescendant { withText("In the news") }
//                    }.perform {
//                        inTheNewsHeaderTitle.hasAnyText()
//                    }
//                }
//            }
//            step("Прокрутите страницу до третьего новостного изображения и щелкните по нему") {
//                flakySafely {
//                    ExploreScreen.items.childWith<InTheNewsCardItem> {
//                        withDescendant { withText("In the news") }
//                    }.perform {
//                        newsCardReaderItems.childAt<NewsCardItem>(2) {
//                            newsCardImage.click()
//                        }
//                    }
//                }
//            }
//            step("Отключите сеть, перейдите ко второй статье, проверьте наличие ошибок и нажмите кнопку «Повторить»") {
//                val retryButton = device.uiDevice.findObject(UiSelector().text("Retry"))//
//                device.network.disable()
//                flakySafely {
//                    FragmentNews.newsStoryItemsRecycler.childAt<NewsCardItems>(1) {
//                        newsCardItemTitle.click()
//                    }
//                    Assert.assertTrue("Кнопка Retry не найдена", retryButton.exists())
//                }
//                device.network.enable()
//                Thread.sleep(5000) // Consider replacing with flakySafely
//                retryButton.click()
//            }
//            step("Измените язык приложения и проверьте текст кнопки") {
//                repeat(2) { device.uiDevice.pressBack() }
//                //repeat(4) { ExploreScreen.items.swipeDown(); Thread.sleep(500) }
//                //device.uiDevice.waitForIdle()
//                device.language.switchInApp(Locale.GERMAN)
//                val navLabel = device.uiDevice.findObject(
//                    UiSelector().resourceId("org.wikipedia.alpha:id/navigation_bar_item_large_label_view")
//                )
//                Assert.assertEquals("Entdecken", navLabel.text)
//            }
//            step("Проверяем, что сейчас активна MainActivity") {
//                device.activities.isCurrent(MainActivity::class.java)
//            }
//        }
//    }
//}