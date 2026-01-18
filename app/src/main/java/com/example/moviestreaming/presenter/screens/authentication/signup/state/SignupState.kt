package com.example.moviestreaming.presenter.screens.authentication.signup.state

data class SignupState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val passwordVisibility: Boolean = false,
    val enableSignUpButton: Boolean = false
)