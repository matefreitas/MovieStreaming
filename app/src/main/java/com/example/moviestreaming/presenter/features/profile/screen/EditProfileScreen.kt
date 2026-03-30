package com.example.moviestreaming.presenter.features.profile.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.hellodev.moviestreaming.core.helper.MaskVisualTransformation
import com.example.moviestreaming.R
import com.example.moviestreaming.presenter.components.button.PrimaryButton
import com.example.moviestreaming.presenter.components.image.ImageUi
import com.example.moviestreaming.presenter.components.textField.TextFieldUI
import com.example.moviestreaming.presenter.components.topAppBar.TopAppBarUI
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
        onBackPressed = onBackPressed
    )
}

@Composable
fun EditProfileContent(
    state: EditProfileState,
    action: (EditProfileAction) -> Unit,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBarUI(
                title = stringResource(id = R.string.label_title_edit_profile_screen),
                onclick = onBackPressed

            )
        },
        containerColor = MovieStreamingTheme.colorScheme.primaryBackgroundColor,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            ImageUi(
                modifier = Modifier.size(140.dp),
                imageModel = "",
                contentScale = ContentScale.Crop,
                previewPlaceholder = painterResource(R.drawable.placeholder_welcome),
                shape = CircleShape,
                isLoading = false,
                onclik = {}
            )

            TextFieldUI(
                value = state.name,
                placeholder = stringResource(id = R.string.label_input_first_name_edit_profile_screen),
                onValueChange = {
                    action(EditProfileAction.OnNameChanged(it))
                }
            )

            TextFieldUI(
                value = state.surname,
                placeholder = stringResource(id = R.string.label_input_surname_edit_profile_screen),
                onValueChange = {
                    action(EditProfileAction.OnSurnameChanged(it))
                }
            )

            TextFieldUI(
                value = "",
                placeholder = stringResource(id = R.string.label_input_email_edit_profile_screen),
                tralingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_email),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                },
                onValueChange = {}
            )

            TextFieldUI(
                value = state.phone,
                placeholder = stringResource(id = R.string.label_input_phone_edit_profile_screen),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),
                maxLenght = MaskVisualTransformation.PHONE_MASK_SIZE,
                visualTransformation = MaskVisualTransformation(MaskVisualTransformation.PHONE_MASK),
                onValueChange = {
                    action(EditProfileAction.OnPhoneChanged(it))
                }
            )

            TextFieldUI(
                value = "",
                placeholder = stringResource(id = R.string.label_input_genre_edit_profile_screen),
                onValueChange = {}
            )

            TextFieldUI(
                value = "",
                placeholder = stringResource(id = R.string.label_input_pais_edit_profile_screen),
                onValueChange = {}
            )

            PrimaryButton(
                text = stringResource(id = R.string.label_button_update_edit_profile_screen),
                isLoading = false,
                enabled = true,
                onclick = {}
            )
        }
    }
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