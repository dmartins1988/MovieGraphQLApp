package com.example.moviegraphql.data

import MovieListQuery
import com.apollographql.apollo3.api.ApolloResponse

interface MovieRemoteDataSource {
    suspend fun getMovies(): ApolloResponse<MovieListQuery.Data>
}