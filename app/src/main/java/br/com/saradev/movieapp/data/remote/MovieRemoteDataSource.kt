package br.com.saradev.movieapp.data.remote

import br.com.saradev.movieapp.data_remote.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getPopularMovies(): Response<MovieList>
}