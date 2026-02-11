package com.example.moviestreaming.di

import com.example.moviestreaming.data.remote.repository.authentication.SignupRepositoryImpl
import com.example.moviestreaming.data.remote.repository.user.UserRepositoryImpl
import com.example.moviestreaming.domain.remote.repository.authentication.SignupRepository
import com.example.moviestreaming.domain.remote.repository.user.UserRepository
import org.koin.dsl.module

val RepositoryModule = module {
    factory <SignupRepository> { SignupRepositoryImpl() }
    factory <UserRepository> { UserRepositoryImpl() }
}