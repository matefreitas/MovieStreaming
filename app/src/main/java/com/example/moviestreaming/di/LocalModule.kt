package com.example.moviestreaming.di

import com.example.moviestreaming.core.preferences.AppPreferences
import org.koin.dsl.module

val localModule = module{
    single<AppPreferences>{
        AppPreferences(context = get())
    }
}