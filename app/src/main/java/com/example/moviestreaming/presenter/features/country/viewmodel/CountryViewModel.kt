package com.example.moviestreaming.presenter.features.country.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviestreaming.domain.local.model.country.Country
import com.example.moviestreaming.presenter.features.country.action.CountryAction
import com.example.moviestreaming.presenter.features.country.state.CountryState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {
    private val _state = MutableStateFlow(CountryState())
    val state = _state.asStateFlow()

    init {
        getCountries()
    }

    fun submitAction(action: CountryAction) {
        when (action) {
            is CountryAction.OnCountrySelected -> {
                onCountrySelected(action.country)
            }
        }
    }

    private fun onCountrySelected(country: Country) {
        _state.value = _state.value.copy(
            selectedCountry = country
        )
    }

    private fun getCountries() {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                countries = Country.items
            )
        }
    }
}