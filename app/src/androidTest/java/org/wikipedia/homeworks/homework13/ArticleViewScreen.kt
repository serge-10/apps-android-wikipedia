package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object ArticleViewScreen : KScreen<ArticleViewScreen>() {
    fun withElement(xpath: Locator, s: String, function: () -> Unit) {

    }

    override val layoutId = null
    override val viewClass = null

    val webView = KWebView {
        withId(R.id.page_web_view)

    }
}