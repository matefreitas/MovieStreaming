package com.example.moviestreaming.di

import com.example.moviestreaming.data.remote.repository.authentication.SignupRepositoryImpl
import com.example.moviestreaming.domain.remote.repository.authentication.SignupRepository
import org.koin.dsl.module

val RepositoryModule = module {
    factory <SignupRepository> { SignupRepositoryImpl() }
}