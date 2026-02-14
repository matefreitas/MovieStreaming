package com.example.moviestreaming.presenter.screens.welcome.action

sealed class WelcomeAction {
    data object OnNextScreen : WelcomeAction()
}