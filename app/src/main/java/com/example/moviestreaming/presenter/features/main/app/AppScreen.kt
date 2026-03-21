package com.example.moviestreaming.presenter.features.main.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.moviestreaming.core.navigation.hosts.bar.BottomAppBarNavHost
import com.example.moviestreaming.presenter.components.bottom.bar.BottomBarUi
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme

@Composable
fun AppScreen(
    navigateToHomeAuthenticator: () -> Unit
) {
    AppContent(
        navigateToHomeAuthenticator = navigateToHomeAuthenticator
    )
}

@Composable
private fun AppContent(
    navigateToHomeAuthenticator: () -> Unit
){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            BottomBarUi(
                currentDestination = currentDestination,
                onItemClick = {
                    navController.navigate(it.route){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        },
        content = {paddingValues ->
            BottomAppBarNavHost(
                modifier = Modifier
                    .background(MovieStreamingTheme.colorScheme.primaryBackgroundColor)
                    .padding(paddingValues),
                navHostController = navController,
                navigateToHomeAuthenticator = navigateToHomeAuthenticator
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun AppScreenPreview(){
    MovieStreamingTheme {
        AppContent(
            navigateToHomeAuthenticator = {}
        )
    }
}