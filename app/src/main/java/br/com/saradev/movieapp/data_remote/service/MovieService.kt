package br.com.saradev.movieapp.data_remote.service

import br.com.saradev.movieapp.data_remote.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
    ): Response<MovieList>
}