package com.example.moviestreaming.presenter.screens.main.account.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.hellodev.moviestreaming.core.enums.menu.MenuType
import com.example.moviestreaming.R
import com.example.moviestreaming.presenter.components.header.HeaderScreen
import com.example.moviestreaming.presenter.components.menu.MenuItemDarkModeUi
import com.example.moviestreaming.presenter.components.menu.MenuItemLanguageUi
import com.example.moviestreaming.presenter.components.menu.MenuItemUi
import com.example.moviestreaming.presenter.components.menu.MenuItems
import com.example.moviestreaming.presenter.components.menu.MenuItems.DarkMode
import com.example.moviestreaming.presenter.components.menu.MenuItems.Language
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
        action = viewModel::submit,
        onItemClick = { menu ->
            when (menu.type) {
                MenuType.EDIT_PROFILE -> {}
                MenuType.NOTIFICATION -> {}
                MenuType.DOWNLOAD -> {}
                MenuType.SECURITY -> {}
                MenuType.LANGUAGE -> {}
                MenuType.DARK_MODE -> {}
                MenuType.HELP_CENTER -> {}
                MenuType.PRIVACY_POLICY -> {}
                MenuType.LOGOUT -> {}
            }
        }
    )
}

@Composable
private fun AccountContent(
    state: AccountState,
    action: (AccountAction) -> Unit,
    onItemClick: (MenuItems) -> Unit
) {
    Scaffold(
        topBar = {
            HeaderScreen(
                modifier = Modifier.padding(
                    top = 24.dp,
                    start = 24.dp,
                    end = 24.dp
                ),
                title = R.string.label_profile_bottom_app_bar
            )
        },
        containerColor = MovieStreamingTheme.colorScheme.backgroundColor,
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(MenuItems.items()) { item ->
                    when (item.type) {
                        MenuType.LANGUAGE -> {
                            MenuItemLanguageUi(
                                icon = item.icon,
                                label = item.label,
                                onClick = { onItemClick(item) }
                            )
                        }

                        MenuType.DARK_MODE -> {
                            MenuItemDarkModeUi(
                                icon = item.icon,
                                label = item.label,
                                isDarkMode = false,
                                onCheckedChange = { onItemClick(item) }
                            )
                        }

                        else -> {
                            MenuItemUi(
                                icon = item.icon,
                                label = item.label,
                                onClick = { onItemClick(item) }
                            )
                        }
                    }
                }
            }
        }
    )
}

@PreviewLightDark
@Composable
private fun AccountPreview() {
    MovieStreamingTheme {
        AccountContent(
            state = AccountState(),
            action = {},
            onItemClick = {}
        )
    }
}