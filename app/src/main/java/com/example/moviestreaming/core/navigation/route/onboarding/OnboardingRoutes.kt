package com.example.moviestreaming.core.navigation.route.onboarding

import kotlinx.serialization.Serializable

sealed class OnboardingRoutes {
    @Serializable
    data object Graph: OnboardingRoutes()
    @Serializable
    data object Splash: OnboardingRoutes()
    @Serializable
    data object Welcome: OnboardingRoutes()
}