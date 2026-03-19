package com.example.moviestreaming.core.navigation.hosts.onboarding

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviestreaming.core.navigation.hosts.app.appNavHost
import com.example.moviestreaming.core.navigation.hosts.authentication.authenticationNavHost
import com.example.moviestreaming.core.navigation.routes.app.AppRoutes
import com.example.moviestreaming.core.navigation.routes.authentication.AuthenticationRoutes
import com.example.moviestreaming.core.navigation.routes.onboarding.OnboardingRoutes
import com.example.moviestreaming.presenter.screens.splash.screen.SplashScreen
import com.example.moviestreaming.presenter.screens.welcome.screen.WelcomeScreen

@Composable
fun OnboardingNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = OnboardingRoutes.Splash
    ){
        composable<OnboardingRoutes.Splash> {
            SplashScreen(
                navigateToAppScreen = {
                    navHostController.navigate(AppRoutes.Graph){
                        popUpTo(OnboardingRoutes.Splash){
                            inclusive = true
                        }
                    }
                },
                navigateToWelcomeScreen = {
                    navHostController.navigate(OnboardingRoutes.Welcome){
                        popUpTo(OnboardingRoutes.Splash){
                            inclusive = true
                        }
                    }
                },
                navigateToHomeAuthenticationScreen = {
                    navHostController.navigate(AuthenticationRoutes.Graph){
                        popUpTo(OnboardingRoutes.Splash){
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<OnboardingRoutes.Welcome> {
            WelcomeScreen(
                navigateToHomeAuthenticationScreen = {
                    navHostController.navigate(AuthenticationRoutes.Graph){
                        popUpTo(OnboardingRoutes.Welcome){
                            inclusive = true
                        }
                    }
                }
            )
        }

        authenticationNavHost(navHostController = navHostController)

        appNavHost(
            navigateToHomeAuthenticator = {
                navHostController.navigate(AuthenticationRoutes.Graph){
                    popUpTo(0) {
                        inclusive = true
                    }
                }
            }
        )
    }
}