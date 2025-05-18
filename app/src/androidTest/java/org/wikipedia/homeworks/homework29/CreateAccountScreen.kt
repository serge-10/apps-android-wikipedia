package org.wikipedia.homeworks.homework29

import io.github.kakaocup.kakao.edit.KTextInputLayout
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.NamedKScreen

object CreateAccountScreen : NamedKScreen<CreateAccountScreen>() {
    override val screenName = "Create an account page"
    override val layoutId = null
    override val viewClass= null

    val usernameField by lazy {
        KTextInputLayout {
            withId(R.id.create_account_username)
        }.setName(withParent("Username field"))
    }

    val passwordField by lazy {
        KTextInputLayout {
            withId(R.id.create_account_password_input)
        }.setName(withParent("Password field"))
    }

    val repeatPasswordField by lazy {
        KTextInputLayout {
            withId(R.id.create_account_password_repeat)
        }.setName(withParent("Repeat Password field"))
    }

    val loginButton by lazy {
        KButton {
            withId(R.id.create_account_login_button)
        }.setName(withParent("Log in button on Create Account screen"))
    }

}