package com.example.moviestreaming.presenter.features.main.favorite.viewmodel

import androidx.lifecycle.ViewModel
import com.example.moviestreaming.presenter.features.main.favorite.action.FavoriteAction
import com.example.moviestreaming.presenter.features.main.favorite.state.FavoriteState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FavoriteViewModel: ViewModel() {
    private val _state = MutableStateFlow(FavoriteState())
    val state = _state.asStateFlow()

    fun submit(action: FavoriteAction) {}
}