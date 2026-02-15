package com.example.moviestreaming.presenter.screens.main.search.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.moviestreaming.presenter.screens.main.search.action.SearchAction
import com.example.moviestreaming.presenter.screens.main.search.state.SearchState
import com.example.moviestreaming.presenter.screens.main.search.viewmodel.SearchViewModel
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen() {
    val viewModel = koinViewModel<SearchViewModel>()
    val state by viewModel.state.collectAsState()

    SearchContent(
        state = state,
        action = viewModel::submitAction
    )
}

@Composable
private fun SearchContent(
    state: SearchState,
    action: (SearchAction) -> Unit
) {

}

@PreviewLightDark
@Composable
private fun SearchScreenPreview() {
    MovieStreamingTheme {
        SearchContent(
            state = SearchState(),
            action = {}
        )
    }
}