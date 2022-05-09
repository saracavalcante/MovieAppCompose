package br.com.saradev.movieapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.saradev.movieapp.domain.usecase.GetPopularMoviesUseCase
import br.com.saradev.movieapp.presentation.HomeStateHolder
import br.com.saradev.movieapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class MovieViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
) : ViewModel() {

    val movies = mutableStateOf(HomeStateHolder())

    init {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        getPopularMoviesUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    movies.value = HomeStateHolder(isLoading = true)
                }
                is Resource.Sucess -> {
                    movies.value = HomeStateHolder(data = it.data)
                }
                is Resource.Error -> {
                    movies.value = HomeStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}