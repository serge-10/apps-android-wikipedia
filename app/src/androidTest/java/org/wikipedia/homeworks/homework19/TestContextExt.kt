package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

private val stepContextCache = mutableMapOf<TestContext<*>, Steps<Any?>>()
val TestContext<*>.steps: Steps<Any?>
    get() = stepContextCache.getOrPut(this) { Steps(this) }