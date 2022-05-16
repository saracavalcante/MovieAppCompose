package br.com.saradev.movieapp.data_remote.repository

import br.com.saradev.movieapp.data_remote.model.MovieResponse
import br.com.saradev.movieapp.data_remote.service.MovieService
import br.com.saradev.movieapp.domain.repository.MovieRepository
import br.com.saradev.movieapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
) : MovieRepository {

    override suspend fun getPopularMovies(apiKey: String): Flow<Resource<MovieResponse>> = flow {
        try {
            val result = movieService.getPopularMovies(apiKey = apiKey)
            if (result.results.isEmpty()) {
                emit(Resource.empty<MovieResponse>())
            } else {
                emit(Resource.success(result))
            }
        } catch (e: Exception) {
            if (e is IOException) {
                emit(Resource.error("No Internet Connection", null))
            } else {
                emit(Resource.error("Something went wrong...", null))
            }
        }
    }
}