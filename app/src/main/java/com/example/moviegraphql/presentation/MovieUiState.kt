package com.example.moviegraphql.presentation

import com.example.moviegraphql.data.Movie

data class MovieUiState(
    val isLoading: Boolean = false,
    val listOfMovies: List<Movie> = emptyList(),
    val error: String? = null
)
