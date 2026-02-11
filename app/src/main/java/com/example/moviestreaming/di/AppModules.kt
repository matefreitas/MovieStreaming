package com.example.moviestreaming.di

import org.koin.dsl.module

val appModules = module {
    includes(RepositoryModule, useCaseModule, presenterModule)
}