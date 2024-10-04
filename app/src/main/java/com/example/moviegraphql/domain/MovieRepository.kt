package com.example.moviegraphql.domain

import com.example.moviegraphql.core.Result
import com.example.moviegraphql.data.Movie

interface MovieRepository {
    suspend fun getMovies(): Result<List<Movie>>
}