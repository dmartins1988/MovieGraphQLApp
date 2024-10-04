package com.example.moviegraphql

import android.app.Application
import com.example.moviegraphql.di.appModule
import com.example.moviegraphql.di.remoteDataSourceModule
import com.example.moviegraphql.di.repositoryModule
import com.example.moviegraphql.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MovieApp)
            androidLogger()
            modules(
                listOf(
                    appModule,
                    remoteDataSourceModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}