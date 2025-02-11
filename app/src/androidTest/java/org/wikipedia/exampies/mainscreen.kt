package org.wikipedia.exampies


import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.views.AppTextView

val imageViewCentered = KImageView {
    withId(R.id.imageViewCentered)
}

fun KImageView(function: () -> Matcher<View>): Any {
    TODO("Not yet implemented")
}

fun main(){
    imageViewCentered.isDisplayed()
}

private fun Any.isDisplayed() {
    TODO("Not yet implemented")
}

val sloganOfWiki = kTextvView{
    withText(R.string.onboarding_welcome_title_v2)
    isInstanceOf(AppTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withId(R.id.primaryTextView)
    }
}

fun isInstanceOf(java: Class<LinearLayout>) {

}

fun withParent(function: () -> Unit) {
    TODO("Not yet implemented")
}

fun isInstanceOf(java: Class<AppTextView>) {

}

fun withText(onboardingWelcomeTitleV2: Int) {

}

fun kTextvView(function: () -> Unit): Any {
    TODO("Not yet implemented")
}
