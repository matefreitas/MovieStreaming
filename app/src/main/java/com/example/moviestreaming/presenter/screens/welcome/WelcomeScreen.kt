package com.example.moviestreaming.presenter.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviestreaming.R
import com.example.moviestreaming.presenter.components.button.PrimaryButton
import com.example.moviestreaming.presenter.components.slider.WelcomeSliderUI
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme

@Composable
fun WelcomeScreen(
    navigateToHomeAuthenticationScreen: () -> Unit
) {
    WelcomeContent(
        navigateToHomeAuthenticationScreen = navigateToHomeAuthenticationScreen
    )
}

@Composable
private fun WelcomeContent(
    navigateToHomeAuthenticationScreen: () -> Unit
) {
    val slideItems = listOf(
        Pair(
            "Bem-vindo",
            "O melhor aplicativo de streaming de filmes do século para tornar seus dias incriveis!"
        ),
        Pair(
            "Bem-vindo",
            "O melhor aplicativo de streaming de filmes do século para tornar seus dias incriveis!"
        ),
        Pair(
            "Bem-vindo",
            "O melhor aplicativo de streaming de filmes do século para tornar seus dias incriveis!"
        ),
    )
    val pagerState = rememberPagerState {
        slideItems.size
    }
    Scaffold(
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = paddingValues.calculateBottomPadding())
                    .background(MovieStreamingTheme.colorScheme.backgroundColor)
            ) {
                Image(
                    painter = painterResource(R.drawable.placeholder_welcome),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Image(
                    painter = painterResource(R.drawable.background_gradient),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    WelcomeSliderUI(
                        modifier = Modifier.weight(1f),
                        slideItems = slideItems,
                        pagerState = pagerState
                    )

                    PrimaryButton(
                        modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 24.dp),
                        text = "Pular",
                        isLoading = false,
                        enabled = true,
                        onclick = navigateToHomeAuthenticationScreen
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun WelcomePreview() {
    WelcomeContent(
        navigateToHomeAuthenticationScreen = {}
    )
}