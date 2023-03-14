package com.fcerio.module.common.extensions

import java.util.regex.Pattern

fun String.isEmailValid(): Boolean {
    return Pattern.compile(
        "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$", Pattern
            .CASE_INSENSITIVE
    ).matcher(this).find()
}

fun String.isEmailValidUsingPattern(): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isNumeric(): Boolean {
    return this.all { char -> char.isDigit() }
}