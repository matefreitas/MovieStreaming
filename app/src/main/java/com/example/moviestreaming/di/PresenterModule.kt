package com.example.moviestreaming.di

import com.example.moviestreaming.presenter.screens.authentication.login.viewmodel.LoginViewModel
import com.example.moviestreaming.presenter.screens.authentication.signup.viewmodel.SignupViewModel
import com.example.moviestreaming.presenter.screens.splash.viewmodel.SplashViewModel
import com.example.moviestreaming.presenter.screens.welcome.viewmodel.WelcomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presenterModule = module {
    viewModel { SignupViewModel(registerUseCase = get(), saveUserUseCase = get()) }
    viewModel { LoginViewModel(loginUseCase = get()) }
    viewModel { WelcomeViewModel(appPreferences = get()) }
    viewModel { SplashViewModel(appPreferences = get()) }
}