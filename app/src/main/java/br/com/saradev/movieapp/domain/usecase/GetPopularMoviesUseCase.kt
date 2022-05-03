package br.com.saradev.movieapp.domain.usecase

import br.com.saradev.movieapp.domain.repository.MovieRepository

class GetPopularMoviesUseCase(
    private val movieRepository: MovieRepository,
) {

    suspend operator fun invoke() =
        movieRepository.getPopularMovies()
}