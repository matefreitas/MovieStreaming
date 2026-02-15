package com.example.moviestreaming.presenter.screens.main.favorite.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.moviestreaming.presenter.screens.main.favorite.action.FavoriteAction
import com.example.moviestreaming.presenter.screens.main.favorite.state.FavoriteState
import com.example.moviestreaming.presenter.screens.main.favorite.viewmodel.FavoriteViewModel
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteScreen() {
    val viewModel = koinViewModel<FavoriteViewModel>()
    val state by viewModel.state.collectAsState()

    FavoriteContent(
        state = state,
        action = viewModel::submit
    )
}

@Composable
private fun FavoriteContent(
    state: FavoriteState,
    action: (FavoriteAction) -> Unit
) {

}

@PreviewLightDark
@Composable
private fun FavoritePreview() {
    MovieStreamingTheme {
        FavoriteContent(
            state = FavoriteState(),
            action = {}
        )
    }
}