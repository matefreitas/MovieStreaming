package com.example.moviestreaming.presenter.screens.authentication.login.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviestreaming.core.enums.feedback.FeedbackType
import com.example.moviestreaming.core.enums.input.InputType
import com.example.moviestreaming.core.functions.isValidEmail
import com.example.moviestreaming.core.helper.FirebaseHelper
import com.example.moviestreaming.domain.remote.usercase.authentication.LoginUseCase
import com.example.moviestreaming.presenter.screens.authentication.login.action.LoginAction
import com.example.moviestreaming.presenter.screens.authentication.login.state.LoginState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun submitAction(action: LoginAction) {
        when (action) {
            is LoginAction.OnValueChange -> {
                onValueChange(action.value, action.type)
            }

            is LoginAction.OnPasswordVisibilityChange -> {
                onPasswordVisibilityChange()
            }

            is LoginAction.OnSignIn -> {
                onSignIn()
            }

            is LoginAction.ResetError -> {
                resetError()
            }
        }
    }

    private fun onSignIn() {
        viewModelScope.launch {
            try {
                loginUseCase.invoke(
                    email = state.value.email,
                    password = state.value.password
                )
                Log.d("Login", "onSignIn: Sucesso ao logar")
            } catch (exception: Exception) {
                exception.printStackTrace()
                _state.update { currentState ->
                    currentState.copy(
                        hasError = true,
                        feedbackUi = Pair(
                            FeedbackType.ERROR,
                            FirebaseHelper.validError(exception.message)
                        )
                    )
                }
            }
        }
    }

    private fun onValueChange(value: String, type: InputType) {
        when (type) {
            InputType.EMAIL -> {
                onEmailChange(value)
            }

            InputType.PASSWORD -> {
                onPasswordChange(value)
            }
        }
        onEnableSignInButton()
    }

    private fun onEmailChange(value: String) {
        _state.update { currentState ->
            currentState.copy(email = value)
        }
    }

    private fun onPasswordChange(value: String) {
        _state.update { currentState ->
            currentState.copy(password = value)
        }
    }

    private fun onPasswordVisibilityChange() {
        _state.update { currentState ->
            currentState.copy(passwordVisibility = !currentState.passwordVisibility)
        }
    }

    private fun onEnableSignInButton() {
        val emailValid = isValidEmail(_state.value.email)
        val passwordValid = state.value.password.isNotBlank()

        _state.update { currentState ->
            currentState.copy(enableSignInButton = emailValid && passwordValid)
        }
    }

    private fun resetError() {
        _state.update { currentState ->
            currentState.copy(hasError = false, feedbackUi = null)
        }
    }

}