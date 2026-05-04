package com.example.moviestreaming.di

import com.example.moviestreaming.presenter.features.authentication.login.viewmodel.LoginViewModel
import com.example.moviestreaming.presenter.features.authentication.signup.viewmodel.SignupViewModel
import com.example.moviestreaming.presenter.features.genre.viewmodel.GenreViewModel
import com.example.moviestreaming.presenter.features.main.account.viewmodel.AccountViewModel
import com.example.moviestreaming.presenter.features.main.download.viewmodel.DownloadViewModel
import com.example.moviestreaming.presenter.features.main.favorite.viewmodel.FavoriteViewModel
import com.example.moviestreaming.presenter.features.main.home.viewmodel.HomeViewModel
import com.example.moviestreaming.presenter.features.main.search.viewmodel.SearchViewModel
import com.example.moviestreaming.presenter.features.profile.viewmodel.EditProfileViewModel
import com.example.moviestreaming.presenter.features.splash.viewmodel.SplashViewModel
import com.example.moviestreaming.presenter.features.welcome.viewmodel.WelcomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presenterModule = module {
    viewModelOf(::SignupViewModel)
    viewModelOf(::LoginViewModel)
    viewModelOf(::WelcomeViewModel)
    viewModelOf(::SplashViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::SearchViewModel)
    viewModelOf(::FavoriteViewModel)
    viewModelOf(::DownloadViewModel)
    viewModelOf(::AccountViewModel)
    viewModelOf(::EditProfileViewModel)
    viewModelOf(::GenreViewModel)
}