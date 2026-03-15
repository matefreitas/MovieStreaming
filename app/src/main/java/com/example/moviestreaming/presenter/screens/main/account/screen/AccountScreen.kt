@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.moviestreaming.presenter.screens.main.account.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.hellodev.moviestreaming.core.enums.menu.MenuType
import com.example.moviestreaming.R
import com.example.moviestreaming.domain.remote.model.User
import com.example.moviestreaming.presenter.components.bottom.sheet.drag.DragBottomsheet
import com.example.moviestreaming.presenter.components.bottom.sheet.logout.BottomSheetLogout
import com.example.moviestreaming.presenter.components.header.HeaderScreen
import com.example.moviestreaming.presenter.components.image.ImageUi
import com.example.moviestreaming.presenter.components.menu.MenuItemDarkModeUi
import com.example.moviestreaming.presenter.components.menu.MenuItemLanguageUi
import com.example.moviestreaming.presenter.components.menu.MenuItemUi
import com.example.moviestreaming.presenter.components.menu.MenuItems
import com.example.moviestreaming.presenter.screens.main.account.action.AccountAction
import com.example.moviestreaming.presenter.screens.main.account.state.AccountState
import com.example.moviestreaming.presenter.screens.main.account.viewmodel.AccountViewModel
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme
import com.example.moviestreaming.presenter.theme.UrbanistFamily
import kotlinx.coroutines.launch
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
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

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
        containerColor = MovieStreamingTheme.colorScheme.primaryBackgroundColor,
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = paddingValues.calculateTopPadding()
                    ),
                contentPadding = PaddingValues(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    ImageUi(
                        modifier = Modifier
                            .size(120.dp),
                        imageModel = state.user?.photo,
                        contentScale = ContentScale.Crop,
                        previewPlaceholder = painterResource(id = R.drawable.placeholder_welcome),
                        shape = CircleShape,
                        isLoading = state.isLoading,
                        onclik = {}
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    if (state.user?.name?.isNotEmpty() == true && state.user.surname?.isNotEmpty() == true) {
                        Text(
                            text = "${state.user.name} ${state.user.surname}",
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 24.sp,
                                fontFamily = UrbanistFamily,
                                fontWeight = FontWeight.Bold,
                                color = MovieStreamingTheme.colorScheme.textColor,
                                textAlign = TextAlign.Center
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = state.user?.email ?: "",
                        style = TextStyle(
                            lineHeight = 19.6.sp,
                            fontFamily = UrbanistFamily,
                            fontWeight = FontWeight.Medium,
                            color = MovieStreamingTheme.colorScheme.textColor,
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.2.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
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
                                onClick = {
                                    if (item.type == MenuType.LOGOUT) {
                                        showBottomSheet = true
                                    } else {
                                        onItemClick(item)
                                    }
                                }
                            )
                        }
                    }
                }
            }

            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState,
                    containerColor = MovieStreamingTheme.colorScheme.secondaryBackgroundColor,
                    dragHandle = {
                        DragBottomsheet()
                    },
                    content = {
                        BottomSheetLogout(
                            onCancelClick = {
                                scope.launch { sheetState.hide() }.invokeOnCompletion {
                                    if (!sheetState.isVisible) {
                                        showBottomSheet = false
                                    }
                                }
                            },
                            onConfirmClick = {}
                        )
                    }
                )
            }
        }
    )
}

@PreviewLightDark
@Composable
private fun AccountPreview() {
    MovieStreamingTheme {
        AccountContent(
            state = AccountState(
                user = User(
                    name = "fulano",
                    surname = "da silva",
                    email = "teste@gmail.com"
                )
            ),
            action = {},
            onItemClick = {}
        )
    }
}