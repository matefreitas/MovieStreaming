package com.example.moviestreaming.presenter.features.welcome.action

sealed class WelcomeAction {
    data object OnNextScreen : WelcomeAction()
}