package com.example.moviestreaming.core.preferences

import android.content.Context
import com.example.moviestreaming.core.constants.SharedPreferencesKeys.FILE_NAME
import com.example.moviestreaming.core.constants.SharedPreferencesKeys.WELCOME_VISITED

class AppPreferences(context: Context) {
    private val sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    fun saveWelcomeVisited(visited: Boolean) {
        sharedPreferences.edit().putBoolean(WELCOME_VISITED, visited).apply()
    }

    fun getWelcomeVisited(): Boolean {
        return sharedPreferences.getBoolean(WELCOME_VISITED, false)
    }
}