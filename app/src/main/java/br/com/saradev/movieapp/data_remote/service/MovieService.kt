package br.com.saradev.movieapp.data_remote.service

import br.com.saradev.movieapp.data_remote.model.MovieDetailResponse
import br.com.saradev.movieapp.data_remote.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String,
    ): MovieResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
    ): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String,
    ): MovieDetailResponse
}