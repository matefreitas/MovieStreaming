package com.example.moviestreaming.presenter.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviestreaming.R
import com.example.moviestreaming.ui.theme.MovieStreamingTheme

@Composable
fun WelcomeScreen() {
    WelcomeContent()
}

@Composable
fun WelcomeContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MovieStreamingTheme.colorScheme.backgroundColor)
    ){
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
    }
}

@Preview
@Composable
private fun WelcomePreview() {
    WelcomeContent()
}