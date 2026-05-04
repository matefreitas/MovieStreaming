package com.example.moviestreaming.presenter.features.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviestreaming.core.enums.input.InputType
import com.example.moviestreaming.core.functions.isValidName
import com.example.moviestreaming.core.functions.isValidPhone
import com.example.moviestreaming.presenter.features.profile.action.EditProfileAction
import com.example.moviestreaming.presenter.features.profile.state.EditProfileState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EditProfileViewModel : ViewModel() {
    private val _state = MutableStateFlow(EditProfileState())
    val state = _state.asStateFlow()

    fun submitAction(action: EditProfileAction) {
        when (action) {
            is EditProfileAction.Update -> {
                updateProfile()
            }

            is EditProfileAction.OnNameChanged -> {
                onNameChanged(name = action.name)
            }

            is EditProfileAction.OnPhoneChanged -> {
                onPhoneChanged(phone = action.phone)
            }

            is EditProfileAction.OnSurnameChanged -> {
                onSurnameChanged(surname = action.surname)
            }

            is EditProfileAction.OnCountryChanged -> {
                onCountryChanged(country = action.country)
            }

            is EditProfileAction.OnGenreChanged -> {
                onGenreChanged(genre = action.genre)
            }
        }
    }

    private fun updateProfile() {
        viewModelScope.launch {
            if (!isValidProfile()) {
                inputFeedBackError()
                return@launch
            }

        }
    }

    private fun onNameChanged(name: String) {
        _state.update {
            it.copy(
                name = name,
                inputError = null,
            )
        }
    }

    private fun onSurnameChanged(surname: String) {
        _state.update {
            it.copy(
                surname = surname,
                inputError = null
            )
        }
    }

    private fun onPhoneChanged(phone: String) {
        _state.update {
            it.copy(
                phone = phone,
                inputError = null
            )
        }
    }

    private fun onGenreChanged(genre: String) {
        _state.update {
            it.copy(
                genre = genre,
                inputError = null
            )
        }
    }

    private fun onCountryChanged(country: String) {
        _state.update {
            it.copy(
                country = country,
                inputError = null
            )
        }
    }

    private fun inputFeedBackError() {
        val inputError = when {
            !isValidName(_state.value.name) -> InputType.FIRST_NAME
            !isValidName(_state.value.surname) -> InputType.SURNAME
            !isValidPhone(_state.value.phone) -> InputType.PHONE
            _state.value.genre.isEmpty() -> InputType.GENRE
            _state.value.country.isEmpty() -> InputType.COUNTRY
            else -> null
        }

        _state.update {
            it.copy(inputError = inputError)
        }
    }

    private fun isValidProfile(): Boolean {
        val name = isValidName(_state.value.name)
        val surname = isValidName(_state.value.name)
        val phone = isValidPhone(_state.value.phone)
        val genre = _state.value.genre.isNotEmpty()
        val country = _state.value.country.isNotEmpty()

        return name && surname && phone && genre && country
    }
}