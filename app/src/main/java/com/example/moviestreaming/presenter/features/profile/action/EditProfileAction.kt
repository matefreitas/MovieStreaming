package com.example.moviestreaming.presenter.features.profile.action

sealed class EditProfileAction {
    data object Update: EditProfileAction()
}