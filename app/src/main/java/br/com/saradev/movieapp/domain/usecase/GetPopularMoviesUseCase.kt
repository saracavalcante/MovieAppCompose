package br.com.saradev.movieapp.domain.usecase

import br.com.saradev.movieapp.domain.model.Movie
import br.com.saradev.movieapp.domain.repository.MovieRepository
import br.com.saradev.movieapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {

    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading(""))
        try {
            emit(Resource.Sucess(movieRepository.getPopularMovies()))
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }
}