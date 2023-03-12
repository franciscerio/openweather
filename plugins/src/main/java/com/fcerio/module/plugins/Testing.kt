package com.fcerio.module.plugins

object Testing {
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Version.ESPRESSO}"
    const val JUNIT = "junit:junit:${Version.JUNIT}"
    const val MOCKK = "io.mockk:mockk:${Version.MOCKK}"
    const val MOCKK_JVM = "io.mockk:mockk-agent-jvm:${Version.MOCKK}"
    const val TEST_RULES = "androidx.test:rules:${Version.TEST_RULES}"
    const val TEST_RUNNER = "androidx.test:runner:${Version.TEST_RUNNER}"
    const val ESPRESSO_CONTRIB =
        "com.android.support.test.espresso:espresso-contrib:${Version.ESPRESSO_CONTRIB}"

    const val COROUTINES_TEST =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.COROUTINES}"
}