package org.wikipedia.homeworks.homework19

import androidx.test.uiautomator.UiObject
import com.kaspersky.kaspresso.device.Device
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.web.WebActions
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework24.KWebViewBaseElement
import org.wikipedia.homeworks.homework24.KWebViewElement

class Action(private val testContext: TestContext<*>) : Steps<Action>(testContext) {

    fun click(item: BaseActions) {
        execute("Click on '${item.name()}'") {
            item.click()
        }
    }

    fun click(item: UiObject) {
        execute("Click on 'UiObject'") {
            item.click()
        }
    }

    fun click(item: WebActions) {
        execute("Click on 'WebActions'") {
            item.click()
        }
    }

    fun click(item: KWebViewBaseElement<*>) {
        scroll(item)
        execute("Click on '${item.name()}'") {
            item.executeAction { click() }
        }
    }

    fun disableNetwork() {
        execute("Disable network") {
            testContext.device.network.disable()
        }
    }

    fun enableNetwork(device: Device) {
        execute("Enable network") {
            device.network.enable()
        }
    }

    fun pressBack() {
        execute("Press Back") {
            testContext.device.uiDevice.pressBack()
        }
    }

    fun swipeUp() {
        execute("Press Back") {
            testContext.device.uiDevice.swipe(
                testContext.device.uiDevice.displayWidth / 2,
                testContext.device.uiDevice.displayHeight * 3 / 4,
                testContext.device.uiDevice.displayWidth / 2,
                testContext.device.uiDevice.displayHeight / 4,
                30
            )
        }
    }

    fun typeText(
        item: EditableActions, text: String
    ) {
        execute("type text:'$text' into '$${item.name()}'") {
            item.typeText(text)
        }
    }

    fun setChecked(item: CheckableActions, checked: Boolean) {
        execute("Set checked state is $checked into ${item.name()}") {
            item.setChecked(checked)
        }
    }

    fun setOrientationLeft() {
        execute("Set orientation left") {
            testContext.device.uiDevice.setOrientationLeft()
        }
    }

    fun setOrientationNatural() {
        execute("Set orientation natural") {
            testContext.device.uiDevice.setOrientationNatural()
        }
    }

    fun setOrientationRight() {
        execute("Set orientation right") {
            testContext.device.uiDevice.setOrientationRight()
        }
    }

    fun scroll(item: WebActions) {
        execute("Scroll '${(item as BaseActions).name()}'") {
            item.scroll()
        }
    }

    fun scroll(item: KWebViewBaseElement<*>) {
        execute("Scroll '${item.name()}'") {
            testContext.flakySafely(150000) {
                item.executeAction { scroll() }
            }
        }
    }

    fun sleep(millis: Long) {
        execute("Take a pause $millis") {
            Thread.sleep(millis)
        }
    }
}