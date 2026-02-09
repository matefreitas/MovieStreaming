package com.example.moviestreaming.di

import com.example.moviestreaming.data.remote.SignupRepositoryImpl
import com.example.moviestreaming.domain.remote.SignupRepository
import org.koin.dsl.module

val RepositoryModule = module {
    factory <SignupRepository> { SignupRepositoryImpl() }
}