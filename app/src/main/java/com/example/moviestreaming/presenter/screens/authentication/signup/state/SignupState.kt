package com.example.moviestreaming.presenter.screens.authentication.signup.state

import com.example.moviestreaming.core.enums.feedback.FeedbackType

data class SignupState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val passwordVisibility: Boolean = false,
    val enableSignUpButton: Boolean = false,
    val hasError: Boolean = false,
    val feedbackUi: Pair<FeedbackType, Int>? = null
)