package com.example.moviestreaming.presenter.features.main.account.state

import com.example.moviestreaming.domain.remote.model.User

data class AccountState(
    val isLoading: Boolean = true,
    val user: User? = null
)
