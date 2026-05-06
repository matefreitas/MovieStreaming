package com.example.moviestreaming.presenter.features.country.action

import com.example.moviestreaming.domain.local.model.country.Country

sealed class CountryAction {
    data class OnCountrySelected(val country: Country) : CountryAction()
    data class OnSearch(val query: String) : CountryAction()
}