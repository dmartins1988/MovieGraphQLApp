package com.example.moviegraphql.data

import MovieListQuery
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse

class MovieRemoteDataSourceImpl(
    private val apolloClient: ApolloClient
) : MovieRemoteDataSource {
    override suspend fun getMovies(): ApolloResponse<MovieListQuery.Data> {
        return apolloClient.query(MovieListQuery()).execute()
    }
}