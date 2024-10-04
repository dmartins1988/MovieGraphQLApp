package com.example.moviegraphql.di

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import com.example.moviegraphql.data.MovieRemoteDataSourceImpl
import com.example.moviegraphql.data.MovieRepositoryImpl
import com.example.moviegraphql.presentation.MovieViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}

fun provideApolloClient(okHttpClient: OkHttpClient): ApolloClient {
    return ApolloClient.Builder()
        .serverUrl("http://10.0.2.2:5000/movie")
        .okHttpClient(okHttpClient)
        .build()
}

val appModule = module {
    single { provideOkHttpClient() }
    single { provideApolloClient(get()) }
}

val remoteDataSourceModule = module {
    single { MovieRemoteDataSourceImpl(get()) }
}

val repositoryModule = module {
    single { MovieRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel {
        MovieViewModel(get())
    }
}