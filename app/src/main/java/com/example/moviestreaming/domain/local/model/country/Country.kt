package com.example.moviestreaming.domain.local.model.country

import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val id: Int? = null,
    val name: String? = null
) {
    companion object {
        val items = listOf<Country>()
    }
}
