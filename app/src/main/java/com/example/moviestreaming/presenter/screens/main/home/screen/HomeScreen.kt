package com.example.moviestreaming.presenter.screens.main.home.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.moviestreaming.presenter.screens.main.home.action.HomeAction
import com.example.moviestreaming.presenter.screens.main.home.state.HomeState
import com.example.moviestreaming.presenter.screens.main.home.viewmodel.HomeViewModel
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen() {
    val viewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsState()

    HomeContent(
        state = state,
        action = viewModel::submitAction
    )
}

@Composable
private fun HomeContent(
    state: HomeState,
    action: (HomeAction) -> Unit
) {

}
@PreviewLightDark
@Composable
fun HomeScreenPreview() {
    MovieStreamingTheme{
        HomeContent(
            state = HomeState(),
            action = {}
        )
    }
}