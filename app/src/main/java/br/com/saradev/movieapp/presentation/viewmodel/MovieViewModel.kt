package br.com.saradev.movieapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.saradev.movieapp.data_remote.model.MovieResponse
import br.com.saradev.movieapp.domain.usecase.GetPopularMoviesUseCase
import br.com.saradev.movieapp.utils.Resource
import br.com.saradev.movieapp.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
) : ViewModel() {

    private val _popularMovies = MutableStateFlow<Resource<MovieResponse>>(Resource.loading(null))
    val popularMovies get() = _popularMovies

    fun getPopularMovies(apiKey: String) {
        viewModelScope.launch {
            getPopularMoviesUseCase.invoke(apiKey).collect {
                when (it.status) {
                    Status.EMPTY -> {
                        _popularMovies.emit(Resource.empty())
                    }
                    Status.SUCCESS -> {
                        _popularMovies.emit(Resource.success(it.data))
                    }
                    else -> {
                        _popularMovies.emit(Resource.error(it.message.toString(), null))
                    }
                }
            }
        }
    }
}
