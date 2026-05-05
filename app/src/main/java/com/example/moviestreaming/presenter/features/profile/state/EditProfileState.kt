package com.example.moviestreaming.presenter.features.profile.state

import com.example.moviestreaming.core.enums.input.InputType
import com.example.moviestreaming.domain.local.model.country.Country
import com.example.moviestreaming.domain.local.model.genre.Genre

data class EditProfileState(
    val isLoading: Boolean = false,
    val name: String = "",
    val surname: String = "",
    val phone: String = "",
    val genre: Genre? = null,
    val country: Country? = null,
    val hasFeedback: Boolean = false,
    val inputError: InputType? = null
)
