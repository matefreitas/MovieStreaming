package com.example.moviestreaming.core.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.moviestreaming.core.navigation.route.hosts.onboarding.OnboardingNavHost
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieStreamingTheme {
                OnboardingNavHost(navHostController = rememberNavController())
            }
        }
    }
}