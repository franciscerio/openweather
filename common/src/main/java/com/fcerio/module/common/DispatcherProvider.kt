package com.fcerio.module.common

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Allow providing different types of [CoroutineDispatcher]s.
 */
interface DispatcherProvider {

    val default: CoroutineDispatcher

    val io: CoroutineDispatcher

    val ui: CoroutineDispatcher

    val uiImmediate: CoroutineDispatcher
}
