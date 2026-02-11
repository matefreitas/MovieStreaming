package com.example.moviestreaming.domain.remote.usercase.authentication

import com.example.moviestreaming.domain.remote.repository.authentication.AuthenticationRepository

class LoginUseCase(
    private val repository: AuthenticationRepository
) {
    suspend operator fun invoke(email: String, password: String) {
        repository.login(email, password)
    }
}