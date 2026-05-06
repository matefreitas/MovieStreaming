package com.example.moviestreaming.presenter.features.country.state

import com.example.moviestreaming.domain.local.model.country.Country

data class CountryState(
    val selectedCountry: Country? = null,
    val countries: List<Country> = emptyList()
)
