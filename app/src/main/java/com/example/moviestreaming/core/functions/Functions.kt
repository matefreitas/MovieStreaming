package com.example.moviestreaming.core.functions

import com.example.moviestreaming.R
import com.example.moviestreaming.core.enums.input.InputType


fun isValidEmail(email: String): Boolean {
    val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    return email.matches(emailRegex.toRegex())
}

fun isValidFirstName(name: String): Boolean {
    val regex = "^[a-zA-Z]{3,}$".toRegex()
    return regex.matches(name)
}

fun isValidSurname(surname: String): Boolean {
    val regex = "^[a-zA-Z]{3,}$".toRegex()
    return regex.matches(surname)
}

fun isValidPhone(phone: String): Boolean {
    val regex = """^\d{2}9\d{8}$""".toRegex()
    return regex.matches(phone)
}

fun inputErrorMessage(type: InputType?): Int {
    return when (type) {
        InputType.FIRST_NAME -> R.string.error_first_name_invalid
        InputType.SURNAME -> R.string.error_surname_invalid
        InputType.PHONE -> R.string.error_phone_invalid
        else -> R.string.error_generic
    }
}