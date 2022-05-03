package br.com.saradev.movieapp.data_remote.datasource

import br.com.saradev.movieapp.data.remote.MovieRemoteDataSource
import br.com.saradev.movieapp.data_remote.service.MovieService
import br.com.saradev.movieapp.data_remote.utils.ApiConstants

class MovieRemoteDataSouceImpl(
    private val movieService: MovieService,
) : MovieRemoteDataSource {

    override suspend fun getPopularMovies() =
        movieService.getPopularMovies(ApiConstants.BASE_URL)
}