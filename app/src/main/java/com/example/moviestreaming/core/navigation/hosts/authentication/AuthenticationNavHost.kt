package com.example.moviestreaming.core.navigation.hosts.authentication

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.moviestreaming.core.navigation.routes.authentication.AuthenticationRoutes
import com.example.moviestreaming.presenter.screens.authentication.home.HomeAuthenticationScreen
import com.example.moviestreaming.presenter.screens.authentication.login.screen.LoginScreen
import com.example.moviestreaming.presenter.screens.authentication.signup.screen.SignupScreen

fun NavGraphBuilder.authenticationNavHost(navHostController: NavHostController) {
    navigation<AuthenticationRoutes.Graph>(
        startDestination = AuthenticationRoutes.Home
    ){
        composable<AuthenticationRoutes.Home>{
            HomeAuthenticationScreen(
                navigateToLoginScreen = {
                    navHostController.navigate(AuthenticationRoutes.Login)
                },
                navigateToSignupScreen = {
                    navHostController.navigate(AuthenticationRoutes.Signup)
                }
            )
        }

        composable<AuthenticationRoutes.Login> {
            LoginScreen(
                onBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }

        composable<AuthenticationRoutes.Signup>{
            SignupScreen(
                onBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }
    }
}