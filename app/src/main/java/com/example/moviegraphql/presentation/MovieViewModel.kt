package com.example.moviegraphql.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviegraphql.core.Result
import com.example.moviegraphql.domain.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private val _state = MutableStateFlow(MovieUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            when (val response = repository.getMovies()) {
                is Result.Error -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = response.error
                        )
                    }
                }

                is Result.Success -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            listOfMovies = response.data
                        )
                    }
                }
            }
        }
    }
}