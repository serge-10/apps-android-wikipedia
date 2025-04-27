package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R
import io.github.kakaocup.kakao.text.KButton as KButton1


object NewOnboardingScreen : NamedKScreen<NewOnboardingScreen>() {
    override val screenName = "Онбординг"
    override val layoutId: Int = R.layout.fragment_onboarding_pager
    override val viewClass: Class<*>? = null


    val skipButton: KButton1 by lazy {
        KButton1 {
            withId(R.id.fragment_onboarding_skip_button)
        }.setName(withParent("Кнопка 'Skip'"))
    }

    val pageIndicator: KView by lazy {
        KView {
            withId(R.id.view_onboarding_page_indicator)
        }.setName(withParent("Индикатор страницы"))
    }

    val forwardButton: KButton1 by lazy {
        KButton1 {
            withId(R.id.fragment_onboarding_forward_button)
        }.setName(withParent("Кнопка 'Forward'"))
    }

    val doneButton: KButton1 by lazy {
        KButton1 {
            withId(R.id.fragment_onboarding_done_button)
        }.setName(withParent("Кнопка 'Done'"))
    }
}