package com.example.moviestreaming.presenter.features.profile.state

data class EditProfileState(
    val isLoading: Boolean = false,
    val name: String = "",
    val surname: String = "",
    val phone: String = ""
)
