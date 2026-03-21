package com.example.moviestreaming.presenter.features.splash.action

sealed class SplashAction {
    data object OnNextScreen : SplashAction()
}