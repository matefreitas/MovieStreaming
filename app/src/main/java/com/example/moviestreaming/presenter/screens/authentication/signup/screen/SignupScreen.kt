package com.example.moviestreaming.presenter.screens.authentication.signup.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moviestreaming.R
import com.example.moviestreaming.core.enums.InputType
import com.example.moviestreaming.presenter.components.button.PrimaryButton
import com.example.moviestreaming.presenter.components.button.SocialButton
import com.example.moviestreaming.presenter.components.divider.HorizontalDividerWithText
import com.example.moviestreaming.presenter.components.textField.TextFieldUI
import com.example.moviestreaming.presenter.components.topAppBar.TopAppBarUI
import com.example.moviestreaming.presenter.screens.authentication.signup.action.SignupAction
import com.example.moviestreaming.presenter.screens.authentication.signup.state.SignupState
import com.example.moviestreaming.presenter.screens.authentication.signup.viewmodel.SignupViewModel
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme
import com.example.moviestreaming.presenter.theme.UrbanistFamily

@Composable
fun SignupScreen(
    onBackPressed: () -> Unit
) {
    val viewModel: SignupViewModel = viewModel()
    val state = viewModel.state.collectAsState().value

    SignupContent(
        state = state,
        action = viewModel::submitAction,
        onBackPressed = onBackPressed
    )
}

@Composable
fun SignupContent(
    state: SignupState,
    action: (SignupAction) -> Unit,
    onBackPressed: () -> Unit = {}
) {

    Scaffold(
        topBar = {
            TopAppBarUI(
                onclick = onBackPressed
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MovieStreamingTheme.colorScheme.backgroundColor)
                    .verticalScroll(rememberScrollState())
                    .padding(paddingValues)
                    .padding(horizontal = 24.dp, vertical = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)

                )

                Spacer(modifier = Modifier.height(48.dp))

                Text(
                    text = stringResource(id = R.string.label_title_singup_screen),
                    style = TextStyle(
                        fontSize = 32.sp,
                        lineHeight = 38.4.sp,
                        fontFamily = UrbanistFamily,
                        fontWeight = FontWeight.Bold,
                        color = MovieStreamingTheme.colorScheme.textColor,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.height(48.dp))

                TextFieldUI(
                    modifier = Modifier,
                    value = state.email,
                    placeholder = stringResource(id = R.string.label_input_email_singup_screen),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_email),
                            contentDescription = null
                        )
                    },
                    onValueChange = {
                        action(SignupAction.OnValueChange(value = it, type = InputType.EMAIL))
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextFieldUI(
                    modifier = Modifier,
                    value = state.password,
                    placeholder = stringResource(id = R.string.label_input_password_singup_screen),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_password),
                            contentDescription = null
                        )
                    },
                    tralingIcon = {
                        if (state.password.isNotEmpty()){
                            IconButton(
                                onClick = {
                                    action(SignupAction.OnPasswordVisibilityChange)
                                },
                                content = {
                                    Icon(
                                        painter = if (state.passwordVisibility){
                                            painterResource(id = R.drawable.ic_hide)
                                        } else {
                                            painterResource(id = R.drawable.ic_show)
                                        },
                                        contentDescription = null
                                    )
                                }
                            )
                        }
                    },
                    visualTransformation = if (state.passwordVisibility) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    onValueChange = {
                        action(SignupAction.OnValueChange(value = it, type = InputType.PASSWORD))
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                PrimaryButton(
                    text = stringResource(id = R.string.label_button_singup_screen),
                    enabled = state.enableSignUpButton,
                    isLoading = false,
                    onclick = {}
                )

                Spacer(modifier = Modifier.height(20.dp))

                HorizontalDividerWithText(text = stringResource(id = R.string.label_or_singup_screen))

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    SocialButton(
                        icon = painterResource(id = R.drawable.ic_google),
                        onclick = {}
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    SocialButton(
                        icon = painterResource(id = R.drawable.ic_facebook),
                        onclick = {}
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    SocialButton(
                        icon = painterResource(id = R.drawable.ic_github),
                        onclick = {}
                    )
                }

                Spacer(modifier = Modifier.height(48.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.label_sing_in_account_singup_screen),
                        style = TextStyle(
                            lineHeight = 19.6.sp,
                            fontFamily = UrbanistFamily,
                            color = MovieStreamingTheme.colorScheme.textColor,
                            textAlign = TextAlign.Right,
                            letterSpacing = 0.2.sp
                        )
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = stringResource(id = R.string.label_sing_in_singup_screen),
                        style = TextStyle(
                            lineHeight = 19.6.sp,
                            fontFamily = UrbanistFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = MovieStreamingTheme.colorScheme.defaultColor,
                            textAlign = TextAlign.Right,
                            letterSpacing = 0.2.sp
                        )
                    )
                }
            }
        }
    )
}

@PreviewLightDark
@Composable
private fun SignupScreenPreview() {
    MovieStreamingTheme {
        SignupScreen(
            onBackPressed = {}
        )
    }
}