package com.example.moviestreaming.di

import com.example.moviestreaming.domain.remote.usercase.authentication.RegisterUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { RegisterUseCase(get()) }
}