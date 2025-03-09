package org.wikipedia.homeworks.homework08

import android.widget.LinearLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.navtab.NavTabLayout
import org.wikipedia.views.AppTextView
import org.wikipedia.views.FaceAndColorDetectImageView
import org.wikipedia.views.WikiCardView

object OnboardingScreen : KScreen<OnboardingScreen>() {
    val logo: Any
        get() {
            TODO()
        }
    override val layoutId = R.layout.fragment_onboarding_pager
    override val viewClass = null

    val slider = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::OnboardingPagerItem)
        }
    )
    val skipButton = KButton{
        withId(R.id.fragment_onboarding_skip_button)
    }

    val pageIndicator = KView{
        withId(R.id.view_onboarding_page_indicator)
    }

    val forwardButton = KButton{
        withId(R.id.fragment_onboarding_forward_button)
    }

    val doneButton = KButton{
        withId(R.id.fragment_onboarding_done_button)
    }
    val topContainer = listOf(
        LinearLayout::class.java,
        "scrollViewContainer",
        null
    )

    val topImage = listOf(
        LinearLayout::class.java,
        "imageViewCentered",
        null
    )

    val onboardingTextDescr = listOf(
        AppTextView::class.java,
        "primaryTextView",
        "onboarding_welcome_title_v2"
    )

    val mainToolbar = listOf(
        MaterialToolbar::class.java,
        "main_toolbar",
        null
    )

    val searchButton = listOf(
        WikiCardView::class.java,
        "search_container",
        "search_hint"
    )

    val announcementHeaderImage = listOf(
        FaceAndColorDetectImageView::class.java,
        "view_announcement_header_image",
        null
    )

    val announcementHeaderText = listOf(
        FaceAndColorDetectImageView::class.java,
        "view_announcement_text",
        "preference_summary_customize_explore_feed"
    )

    val negativeButton = listOf(
        MaterialButton::class.java,
        "view_announcement_action_negative",
        "feed_configure_onboarding_action"
    )

    val positiveButton = listOf(
        MaterialButton::class.java,
        "view_announcement_action_positive",
        "onboarding_got_it"
    )

    val navigationTabLayout = listOf(
        NavTabLayout::class.java,
        "main_nav_tab_layout",
        null
    )
}