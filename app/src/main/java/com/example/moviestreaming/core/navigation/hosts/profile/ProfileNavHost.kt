package com.example.moviestreaming.core.navigation.hosts.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.moviestreaming.core.navigation.routes.profile.ProfileRoutes
import com.example.moviestreaming.presenter.features.profile.screen.EditProfileScreen

fun NavGraphBuilder.ProfileNavHost(
    navHostController: NavHostController
) {
    navigation<ProfileRoutes.Graph>(
        startDestination = ProfileRoutes.EditProfile
    ) {
        composable<ProfileRoutes.EditProfile> {
            EditProfileScreen(
                onBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }
    }
}