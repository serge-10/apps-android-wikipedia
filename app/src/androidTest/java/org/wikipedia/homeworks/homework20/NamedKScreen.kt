package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.actions.BaseActions as BaseActions1
import io.github.kakaocup.kakao.common.assertions.BaseAssertions as BaseAssertions1

abstract class NamedKScreen<out T : KScreen<T>> : KScreen<T>() {

    abstract val customizeButton: BaseActions1
    abstract val searchIcon: BaseAssertions1
    abstract val screenName: String
    val nameHierarchy by lazy { NameHierarchy(screenName) }

    fun withParent(elementName: String) = nameHierarchy.withParent(elementName)
    abstract fun topReadItemText(): Any
}
