package com.example.moviestreaming.core.navigation.hosts.bar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviestreaming.core.navigation.hosts.profile.profileNavHost
import com.example.moviestreaming.core.navigation.routes.bar.BottomAppBarRoutes
import com.example.moviestreaming.core.navigation.routes.profile.ProfileRoutes
import com.example.moviestreaming.presenter.features.main.account.screen.AccountScreen
import com.example.moviestreaming.presenter.features.main.download.screen.DownloadScreen
import com.example.moviestreaming.presenter.features.main.favorite.screen.FavoriteScreen
import com.example.moviestreaming.presenter.features.main.home.screen.HomeScreen
import com.example.moviestreaming.presenter.features.main.search.screen.SearchScreen

@Composable
fun BottomAppBarNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    navigateToHomeAuthenticator: () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomAppBarRoutes.Home,
        modifier = modifier
    ) {
        composable<BottomAppBarRoutes.Home> {
            HomeScreen()
        }
        composable<BottomAppBarRoutes.Search> {
            SearchScreen()
        }
        composable<BottomAppBarRoutes.Favorite> {
            FavoriteScreen()
        }
        composable<BottomAppBarRoutes.Download> {
            DownloadScreen()
        }
        composable<BottomAppBarRoutes.Account> {
            AccountScreen(
                navigateToHomeAuthenticator = navigateToHomeAuthenticator,
                navigateToEditProfileScreen = {
                    navHostController.navigate(ProfileRoutes.EditProfile)
                }
            )
        }

        profileNavHost(navHostController = navHostController)
    }
}