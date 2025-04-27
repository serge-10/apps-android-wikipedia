package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.homeworks.homework24.KWebViewBaseElement

object ArticleViewScreen : KScreen<ArticleViewScreen>() {
    fun withElement(xpath: Locator, s: String, function: KWebViewBaseElement.() -> Unit) {

    }

    override val layoutId = null
    override val viewClass = null

    val webView = KWebView {
        withId(R.id.page_web_view)

    }
}