package com.example.moviegraphql.core

sealed interface Result<out T> {
    data class Success<out T>(val data: T) : Result<T>
    data class Error<out T>(val error: String) : Result<T>
}