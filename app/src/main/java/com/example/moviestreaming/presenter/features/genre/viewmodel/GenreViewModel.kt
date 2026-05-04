package com.example.moviestreaming.presenter.features.genre.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviestreaming.domain.local.model.Genre.Genre
import com.example.moviestreaming.presenter.features.genre.action.GenreAction
import com.example.moviestreaming.presenter.features.genre.state.GenreState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GenreViewModel : ViewModel() {
    private val _state = MutableStateFlow(GenreState())
    val state = _state.asStateFlow()

    init {
        getGenres()
    }

    fun submitAction(action: GenreAction) {
        when (action) {
            is GenreAction.OnGenreSelected -> {
                onGenreSelected(genre = action.genre)
            }
        }
    }

    private fun onGenreSelected(genre: Genre) {
        _state.value = _state.value.copy(
            selectedGenre = genre
        )
    }

    private fun getGenres() {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                genres = Genre.genres
            )
        }
    }
}