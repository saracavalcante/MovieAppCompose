package br.com.saradev.movieapp.data_remote.service

import br.com.saradev.movieapp.data_remote.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
    ): MovieResponse
}