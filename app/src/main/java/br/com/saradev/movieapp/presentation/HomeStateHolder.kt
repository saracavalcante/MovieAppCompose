package br.com.saradev.movieapp.presentation

import br.com.saradev.movieapp.domain.model.Movie

data class HomeStateHolder(
    val isLoading: Boolean = false,
    val data: List<Movie>? = null,
    val error: String = "",
)