package com.example.moviestreaming.core.navigation.hosts.onboarding

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviestreaming.core.navigation.routes.onboarding.OnboardingRoutes
import com.example.moviestreaming.presenter.screens.splash.SplashScreen
import com.example.moviestreaming.presenter.screens.welcome.WelcomeScreen

@Composable
fun OnboardingNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = OnboardingRoutes.Splash
    ){
        composable<OnboardingRoutes.Splash> {
            SplashScreen(
                navigateToWelcomeScreen = {
                    navHostController.navigate(OnboardingRoutes.Welcome){
                        popUpTo(OnboardingRoutes.Splash){
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<OnboardingRoutes.Welcome> {
            WelcomeScreen()
        }
    }
}