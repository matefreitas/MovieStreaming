package com.example.moviestreaming.presenter.features.main.download.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.moviestreaming.presenter.features.main.download.action.DownloadAction
import com.example.moviestreaming.presenter.features.main.download.state.DownloadState
import com.example.moviestreaming.presenter.features.main.download.viewmodel.DownloadViewModel
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DownloadScreen() {
    val viewmodel = koinViewModel<DownloadViewModel>()
    val state by viewmodel.state.collectAsState()

    DownloadContent(
        state = state,
        action = viewmodel::submit
    )
}

@Composable
private fun DownloadContent(
    state: DownloadState,
    action: (DownloadAction) -> Unit,
) {

}

@PreviewLightDark
@Composable
private fun DownloadPreview() {
    MovieStreamingTheme{
        DownloadContent(
            state = DownloadState(),
            action = {}
        )
    }
}