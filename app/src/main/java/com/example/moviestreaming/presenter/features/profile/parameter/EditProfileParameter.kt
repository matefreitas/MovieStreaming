package com.example.moviestreaming.presenter.features.profile.parameter

import com.example.moviestreaming.domain.local.model.country.Country
import com.example.moviestreaming.domain.local.model.genre.Genre
import kotlinx.serialization.Serializable

@Serializable
data class EditProfileParameter(
    val genre: Genre? = null,
    val country: Country? = null
)
