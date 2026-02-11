package com.example.moviestreaming.di

import com.example.moviestreaming.domain.remote.usercase.authentication.RegisterUseCase
import com.example.moviestreaming.domain.remote.usercase.user.SaveUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { RegisterUseCase(get()) }
    factory { SaveUserUseCase(get()) }
}