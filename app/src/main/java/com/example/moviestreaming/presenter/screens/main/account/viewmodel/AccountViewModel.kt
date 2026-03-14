package com.example.moviestreaming.presenter.screens.main.account.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moviestreaming.domain.remote.usercase.user.GetUserUseCase
import com.example.moviestreaming.presenter.screens.main.account.action.AccountAction
import com.example.moviestreaming.presenter.screens.main.account.state.AccountState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AccountViewModel(
    private val getUserUseCase: GetUserUseCase
): ViewModel() {
    private val _state = MutableStateFlow(AccountState())
    val state = _state.asStateFlow()

    init {
        getUser()
    }

    fun submit(action: AccountAction){}

    private fun getUser(){
        viewModelScope.launch {
            val user = getUserUseCase()

            _state.value = _state.value.copy(
                user = user,
                isLoading = false
            )
        }
    }
}