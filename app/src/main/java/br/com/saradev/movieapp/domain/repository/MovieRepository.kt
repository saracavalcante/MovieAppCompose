package br.com.saradev.movieapp.domain.repository

import br.com.saradev.movieapp.data_remote.model.MovieDetailResponse
import br.com.saradev.movieapp.data_remote.model.MovieResponse
import br.com.saradev.movieapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getUpcomingMovies(apiKey: String): Flow<Resource<MovieResponse>>
    suspend fun getPopularMovies(apiKey: String): Flow<Resource<MovieResponse>>
    suspend fun getMovieDetails(
        apiKey: String,
        movieId: String,
    ): Flow<Resource<MovieDetailResponse>>

}