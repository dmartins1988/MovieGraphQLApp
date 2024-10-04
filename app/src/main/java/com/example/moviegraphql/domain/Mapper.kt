package com.example.moviegraphql.domain

import MovieListQuery
import com.example.moviegraphql.data.Movie

fun MovieListQuery.Movie.toMovie(): Movie {
    return Movie(
        title = name,
        thumb = thumb
    )
}