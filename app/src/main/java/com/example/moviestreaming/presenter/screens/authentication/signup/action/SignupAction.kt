package com.example.moviestreaming.presenter.screens.authentication.signup.action

import com.example.moviestreaming.core.enums.InputType

sealed class SignupAction {
    data class OnValueChange(val value: String, val type: InputType): SignupAction()

    data object OnPasswordVisibilityChange: SignupAction()
}