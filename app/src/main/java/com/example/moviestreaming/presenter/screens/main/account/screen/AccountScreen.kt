package com.example.moviestreaming.presenter.screens.main.account.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.moviestreaming.presenter.screens.main.account.action.AccountAction
import com.example.moviestreaming.presenter.screens.main.account.state.AccountState
import com.example.moviestreaming.presenter.screens.main.account.viewmodel.AccountViewModel
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun AccountScreen() {
    val viewModel = koinViewModel<AccountViewModel>()
    val state by viewModel.state.collectAsState()

    AccountContent(
        state = state,
        action = viewModel::submit
    )
}

@Composable
private fun AccountContent(
    state: AccountState,
    action: (AccountAction) -> Unit
) {

}

@PreviewLightDark
@Composable
private fun AccountPreview() {
    MovieStreamingTheme {
        AccountContent(
            state = AccountState(),
            action = {}
        )
    }
}