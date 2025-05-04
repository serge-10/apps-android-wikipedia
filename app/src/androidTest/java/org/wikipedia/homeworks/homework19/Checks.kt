package org.wikipedia.homeworks.homework19

import androidx.room.CoroutinesRoom.Companion.execute
import com.kaspersky.components.kautomator.component.text.UiTextViewAssertions
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.image.ImageViewAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import io.github.kakaocup.kakao.web.WebAssertions
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework21.hasAnyDrawable
import org.wikipedia.homeworks.homework24.KWebViewBaseElement

class Checks(private val testContext: TestContext<*>) : Steps<Checks>(testContext) {
    fun hasText(item: TextViewAssertions, text: String) {
        execute("${(item as BaseActions).name()} has a text: '$text'") {
            item.hasText(text)
        }
    }

    fun hasText(item: WebAssertions, text: String) {
        execute("${(item as BaseActions).name()} has a text: '$text'") {
            item.hasText(text)
        }
    }

    fun hasText(item: KWebViewBaseElement<*>, text: String) {
        execute("'${item.name()}' has a text: '$text'") {
            item.executeAction { hasText(text) }
        }
    }

    fun hasAnyText(item: TextViewAssertions) {
        execute("${(item as BaseActions).name()} has any text") {
            item.hasAnyText()
        }
    }

    fun hasAnyDrawable(item: ImageViewAssertions) {
        execute("'${(item as BaseActions).name()}' has  any Image") {
            item.hasAnyDrawable()
        }
    }

    fun containsText(item: KWebViewBaseElement<*>, text: String) {
        execute("${item.name()} contains a text: '$text'") {
            item.executeAction { containsText(text) }
        }
    }

    fun containsText(item: UiTextViewAssertions, text: String) {
        execute("${(item as BaseActions).name()} contains a text: '$text'") {
            item.containsText(text)
        }
    }

    fun isChecked(item: CheckableAssertions) {
        execute("${(item as BaseActions).name()} is isChecked") {
            item.isChecked()
        }
    }

    fun isNotChecked(item: CheckableAssertions) {
        execute("${(item as BaseActions).name()} isn't isChecked") {
            item.isNotChecked()
        }
    }

    fun isDisplayed(item: BaseAssertions) {
        execute("${(item as BaseActions).name()} is displayed") {
            item.isDisplayed()
        }
    }

    fun isCompletelyDisplayed(item: BaseAssertions) {
        execute("${(item as BaseActions).name()} is Completely displayed") {
            item.isCompletelyDisplayed()
        }
    }

    fun isNotOrientationNatural() {
        execute("Check orientation isn't Natural") {
            assert(!testContext.device.uiDevice.isNaturalOrientation())
        }
    }

    fun isOrientationNatural() {
        execute("Check orientation is Natural") {
            assert(testContext.device.uiDevice.isNaturalOrientation())
        }

    }
}