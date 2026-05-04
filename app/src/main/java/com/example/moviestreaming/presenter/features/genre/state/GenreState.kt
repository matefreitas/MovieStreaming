package com.example.moviestreaming.presenter.features.genre.state

import com.example.moviestreaming.domain.local.model.Genre.Genre

data class GenreState(
    val selectedGenre: Genre? = null,
    val genres: List<Genre> = emptyList()
)
