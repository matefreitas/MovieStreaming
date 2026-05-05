package com.example.moviestreaming.presenter.features.genre.action

import com.example.moviestreaming.domain.local.model.genre.Genre

sealed class GenreAction {
    data class OnGenreSelected(val genre: Genre): GenreAction()
}