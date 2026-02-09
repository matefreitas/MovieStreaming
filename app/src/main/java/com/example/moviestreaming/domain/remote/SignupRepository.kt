package com.example.moviestreaming.domain.remote

interface SignupRepository {

    suspend fun register(email: String, password: String)
}