package com.example.moviestreaming.domain.remote.usercase.authentication

import com.example.moviestreaming.domain.remote.repository.authentication.SignupRepository

class RegisterUseCase(
    private val repository: SignupRepository
) {
    suspend operator fun invoke(email: String, password: String) {
        repository.register(email, password)
    }
}