package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.screens.KScreen

abstract class NamedKScreen<out T : KScreen<T>> : KScreen<T>() {
    object items {
        fun <T> invokeByID(targetIndex: Int, targetID: Int, blockName: String, limiter: Int, function: T.() -> Unit) {

        }

        fun getName(): Any {

        }

    }

    abstract val screenName: String
    private val nameHierarchy by lazy { NameHierarchy(screenName) }

    fun withParent(elementName: String) = nameHierarchy.withParent(elementName)
}
