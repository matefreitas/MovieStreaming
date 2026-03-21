package com.example.moviestreaming.presenter.features.authentication.login.action

import com.example.moviestreaming.core.enums.input.InputType

sealed class LoginAction {
    data class OnValueChange(val value: String, val type: InputType): LoginAction()

    data object OnPasswordVisibilityChange: LoginAction()

    data object OnSignIn: LoginAction()

    data object ResetError: LoginAction()

}