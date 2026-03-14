package com.example.moviestreaming.domain.remote.usercase.user

import com.example.moviestreaming.domain.remote.model.User
import com.example.moviestreaming.domain.remote.repository.user.UserRepository

class GetUserUseCase(
    private val repository: UserRepository
) {

    suspend operator fun invoke(): User{
        return repository.getUser()
    }
}