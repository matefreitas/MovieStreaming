package com.example.moviestreaming.presenter.screens.authentication.login.state

import com.example.moviestreaming.core.enums.feedback.FeedbackType

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val passwordVisibility: Boolean = false,
    val enableSignInButton: Boolean = false,
    val hasError: Boolean = false,
    val feedbackUi: Pair<FeedbackType, Int>? = null
)