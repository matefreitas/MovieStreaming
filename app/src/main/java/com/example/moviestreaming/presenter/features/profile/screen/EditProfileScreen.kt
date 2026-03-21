package com.example.moviestreaming.presenter.features.profile.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.moviestreaming.presenter.features.profile.action.EditProfileAction
import com.example.moviestreaming.presenter.features.profile.state.EditProfileState
import com.example.moviestreaming.presenter.features.profile.viewmodel.EditProfileViewModel
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun EditProfileScreen(
    onBackPressed: () -> Unit
) {
    val viewModel = koinViewModel<EditProfileViewModel>()
    val state by viewModel.state.collectAsState()

    EditProfileContent(
        state = state,
        action = viewModel::submitAction,
        onBackPressed = {}
    )
}

@Composable
fun EditProfileContent(
    state: EditProfileState,
    action: (EditProfileAction) -> Unit,
    onBackPressed: () -> Unit
) {
    
}

@PreviewLightDark
@Composable
private fun EditProfileScreenPreview() {
    MovieStreamingTheme {
        EditProfileContent(
            state = EditProfileState(),
            action = {},
            onBackPressed = {}
        )
    }
}