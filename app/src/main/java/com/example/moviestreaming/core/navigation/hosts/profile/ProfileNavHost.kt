package com.example.moviestreaming.core.navigation.hosts.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.moviestreaming.core.constants.NavigationKeys.EDIT_PROFILE_SCREEN_KEYS
import com.example.moviestreaming.core.navigation.extensions.getObject
import com.example.moviestreaming.core.navigation.extensions.putObject
import com.example.moviestreaming.core.navigation.routes.profile.ProfileRoutes
import com.example.moviestreaming.presenter.features.genre.screen.GenreScreen
import com.example.moviestreaming.presenter.features.profile.parameter.EditProfileParameter
import com.example.moviestreaming.presenter.features.profile.screen.EditProfileScreen

fun NavGraphBuilder.profileNavHost(
    navHostController: NavHostController
) {
    navigation<ProfileRoutes.Graph>(
        startDestination = ProfileRoutes.EditProfile
    ) {
        composable<ProfileRoutes.EditProfile> { backStackEntry ->
            val parameter = backStackEntry.savedStateHandle.getObject<EditProfileParameter>(
                key = EDIT_PROFILE_SCREEN_KEYS
            )
            EditProfileScreen(
                parameter = parameter,
                navigateToGenreScreen = {
                    navHostController.navigate(ProfileRoutes.Genre)
                },
                onBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }

        composable<ProfileRoutes.Genre> {
            GenreScreen(
                onGenreSelected = { genre ->
                    val parameter = EditProfileParameter(genre = genre)
                    navHostController.previousBackStackEntry?.savedStateHandle?.putObject(
                        key = EDIT_PROFILE_SCREEN_KEYS,
                        value = parameter
                    )
                    navHostController.popBackStack()
                },
                onBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }
    }
}