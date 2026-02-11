package com.example.moviestreaming.domain.remote.usercase.user

import com.example.moviestreaming.domain.remote.model.User
import com.example.moviestreaming.domain.remote.repository.user.UserRepository

class SaveUserUseCase(
    private val repository: UserRepository
) {

    suspend operator fun invoke(user: User){
        repository.save(user)
    }
}