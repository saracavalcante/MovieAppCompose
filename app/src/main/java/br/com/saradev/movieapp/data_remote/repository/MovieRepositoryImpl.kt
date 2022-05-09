package br.com.saradev.movieapp.data_remote.repository

import br.com.saradev.movieapp.data_remote.service.MovieService
import br.com.saradev.movieapp.domain.mappers.toDomain
import br.com.saradev.movieapp.domain.model.Movie
import br.com.saradev.movieapp.domain.repository.MovieRepository
import br.com.saradev.movieapp.utils.SafeApiRequest
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
) : MovieRepository, SafeApiRequest() {

    override suspend fun getPopularMovies(): List<Movie> {
        val response = safeApiRequest { movieService.getPopularMovies() }
        return response.results?.toDomain()!!
    }
}