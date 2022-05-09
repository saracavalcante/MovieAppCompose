package br.com.saradev.movieapp.data_remote.service

import br.com.saradev.movieapp.data_remote.model.MoviesDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = "71f2a5e501cd9c5855b78f94012a33f4",
    ): Response<MoviesDTO>
}