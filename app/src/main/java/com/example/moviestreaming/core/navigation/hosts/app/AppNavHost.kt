package com.example.moviestreaming.core.navigation.hosts.app

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.moviestreaming.core.navigation.routes.app.AppRoutes
import com.example.moviestreaming.presenter.screens.main.app.AppScreen

fun NavGraphBuilder.appNavHost(){
    navigation<AppRoutes.Graph>(
        startDestination = AppRoutes.App
    ){
        composable <AppRoutes.App>{
            AppScreen()
        }
    }
}