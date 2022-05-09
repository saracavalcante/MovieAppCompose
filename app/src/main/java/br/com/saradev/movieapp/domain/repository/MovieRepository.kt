package br.com.saradev.movieapp.domain.repository

import br.com.saradev.movieapp.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>
}