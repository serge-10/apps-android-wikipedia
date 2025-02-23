package org.wikipedia.exampies


import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.wikipedia.R
import org.wikipedia.views.AppTextView
import org.wikipedia.TestUtil.waitOnId

// Matcher for the image view
val imageViewCentered = KImageView {
    withId(R.id.imageViewCentered)
}

// Helper function for KImageView
fun KImageView(function: () -> Matcher<View>): Matcher<View> {
    return function()
}

// Custom matcher for checking if a view is displayed
private fun Matcher<View>.isDisplayed(): Matcher<View> {
    return allOf(this, isDisplayed())
}

// Example usage of `sloganOfWiki`
val sloganOfWiki = kTextvView {
    withText(R.string.onboarding_welcome_title_v2)
    isInstanceOf(AppTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
        withId(R.id.primaryTextView)
    }
}

// Function to check instance of a class type
fun isInstanceOf(java: Class<out View>): Matcher<View> {
    return Matchers.instanceOf(java)
}

// Function to check parent view
fun withParent(function: () -> Matcher<View>): Matcher<View> {
    return withParent(function())
}

// Function to match text on the view
fun withText(text: Int): Matcher<View> {
    return withText(text)
}

// Example kTextvView matcher function
fun kTextvView(function: () -> Unit): Matcher<View> {
    // Custom implementation for kTextvView
    return withText(R.string.onboarding_welcome_title_v2) // You can add more logic if needed
}

// Main function to demonstrate usage
fun main() {
    // Sample usage, assuming you are testing an image view
    val imageViewMatcher = imageViewCentered
    // Add logic to check the image view, e.g., in Espresso tests
    imageViewMatcher.isDisplayed()

    // Example test with sloganOfWiki
    sloganOfWiki // Perform matching logic here in your test
}

