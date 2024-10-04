package com.example.moviegraphql.data

import com.example.moviegraphql.core.Result
import com.example.moviegraphql.domain.MovieRepository
import com.example.moviegraphql.domain.toMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepositoryImpl(
    private val remoteDataSource: MovieRemoteDataSource
) : MovieRepository {
    override suspend fun getMovies(): Result<List<Movie>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = remoteDataSource.getMovies()
                if (response.hasErrors().not()) {
                    Result.Success(response.data?.movies?.map { it?.toMovie() ?: Movie() }
                        ?: emptyList())
                } else {
                    Result.Error(error = response.errors.toString())
                }
            } catch (e: Exception) {
                Result.Error(error = e.localizedMessage?.toString() ?: "Unknown Error")
            }
        }
    }
}