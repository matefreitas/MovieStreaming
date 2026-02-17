package com.example.moviestreaming.core.navigation.hosts.app

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.moviestreaming.core.navigation.routes.app.AppRoutes
import com.example.moviestreaming.presenter.screens.main.app.AppScreen

fun NavGraphBuilder.appNavHost(navHostController: NavHostController){
    navigation<AppRoutes.Graph>(
        startDestination = AppRoutes.Graph
    ){
        composable <AppRoutes.App>{
            AppScreen()
        }
    }
}