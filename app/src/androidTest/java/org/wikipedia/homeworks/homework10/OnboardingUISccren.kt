package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUISccren:UiScreen<OnboardingUISccren>() {
    override val packageName = "org.wikipedia.test"

    val image = UiView{
        withId(this@OnboardingUISccren.packageName,"imageViewCentered")
    }
}

