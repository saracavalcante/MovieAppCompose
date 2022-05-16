package br.com.saradev.movieapp.domain.usecase

import br.com.saradev.movieapp.data_remote.model.MovieResponse
import br.com.saradev.movieapp.domain.repository.MovieRepository
import br.com.saradev.movieapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {

    suspend operator fun invoke(apiKey: String): Flow<Resource<MovieResponse>> {
        return movieRepository.getPopularMovies(apiKey)
    }
}