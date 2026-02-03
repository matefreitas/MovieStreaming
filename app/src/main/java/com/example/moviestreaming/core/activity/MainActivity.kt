package com.example.moviestreaming.core.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.moviestreaming.presenter.screens.authentication.signup.screen.SignupScreen
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieStreamingTheme {
                //SplashScreen()
                //WelcomeScreen()
                //HomeAuthenticationScreen()
                SignupScreen(
                    onBackPressed = {}
                )
            }
        }
    }
}