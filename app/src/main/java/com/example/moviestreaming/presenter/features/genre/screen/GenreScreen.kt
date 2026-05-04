package com.example.moviestreaming.presenter.features.genre.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.moviestreaming.domain.local.model.Genre.Genre
import com.example.moviestreaming.presenter.components.button.PrimaryButton
import com.example.moviestreaming.presenter.components.radio.RadioButtonUi
import com.example.moviestreaming.presenter.components.topAppBar.TopAppBarUI
import com.example.moviestreaming.presenter.features.genre.action.GenreAction
import com.example.moviestreaming.presenter.features.genre.state.GenreState
import com.example.moviestreaming.presenter.features.genre.viewmodel.GenreViewModel
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun GenreScreen(
    onBackPressed: () -> Unit
) {
    val viewModel = koinViewModel<GenreViewModel>()
    val state by viewModel.state.collectAsState()

    GenreContent(
        state = state,
        action = viewModel::submitAction,
        onBackPressed = onBackPressed
    )
}

@Composable
private fun GenreContent(
    state: GenreState,
    action: (GenreAction) -> Unit,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBarUI(
                title = "Gêneros",
                onclick = onBackPressed
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .background(MovieStreamingTheme.colorScheme.primaryBackgroundColor)
            ) {
                HorizontalDivider()
                PrimaryButton(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 32.dp),
                    text = "Selecionar",
                    enabled = state.selectedGenre != null,
                    onclick = { }
                )
            }
        },
        containerColor = MovieStreamingTheme.colorScheme.primaryBackgroundColor
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                bottom = 24.dp,
                top = 8.dp
            )
        ) {
            items(state.genres) { item ->
                RadioButtonUi(
                    selected = item == state.selectedGenre,
                    text = item.name ?: "",
                    onClick = {
                        action(GenreAction.OnGenreSelected(item))
                    }
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun GenrePreview() {
    MovieStreamingTheme {
        GenreContent(
            state = GenreState(
                genres = Genre.genres
            ),
            action = {},
            onBackPressed = {}
        )
    }
}