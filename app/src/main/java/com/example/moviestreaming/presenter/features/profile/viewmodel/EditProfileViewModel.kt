package com.example.moviestreaming.presenter.features.profile.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.moviestreaming.presenter.features.profile.action.EditProfileAction
import com.example.moviestreaming.presenter.features.profile.state.EditProfileState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EditProfileViewModel() : ViewModel() {
    private val _state = MutableStateFlow(EditProfileState())
    val state = _state.asStateFlow()

    fun submitAction(action: EditProfileAction) {
        when (action) {
            is EditProfileAction.Update -> {}
            is EditProfileAction.OnNameChanged -> {
                onNameChanged(name = action.name)
            }
            is EditProfileAction.OnPhoneChanged -> {
                onPhoneChanged(phone = action.phone)
            }
            is EditProfileAction.OnSurnameChanged -> {
                onSurnameChanged(surname = action.surname)
            }
        }
    }

    private fun onNameChanged(name: String) {
        _state.update {
            it.copy(name = name)
        }
    }

    private fun onSurnameChanged(surname: String) {
        _state.update {
            it.copy(surname = surname)
        }
    }

    private fun onPhoneChanged(phone: String) {
        _state.update {
            it.copy(phone = phone)
        }
    }
}