package br.com.saradev.movieapp.domain.repository

import br.com.saradev.movieapp.data_remote.model.MovieList

interface MovieRepository {
    suspend fun getPopularMovies(): Result<MovieList>
}