package com.example.moviestreaming.domain.remote.repository.user

import com.example.moviestreaming.domain.remote.model.User

interface UserRepository {
    suspend fun save(user: User)
}