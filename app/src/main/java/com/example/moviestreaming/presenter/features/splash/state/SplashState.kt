package com.example.moviestreaming.presenter.features.splash.state

data class SplashState(
    val isWelcomeVisited: Boolean = false,
    val isLoading: Boolean = true,
    val isAuthenticated: Boolean = false
)
