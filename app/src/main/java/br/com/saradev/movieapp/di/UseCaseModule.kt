package br.com.saradev.movieapp.di

import br.com.saradev.movieapp.domain.repository.MovieRepository
import br.com.saradev.movieapp.domain.usecase.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetPopularMoviesUseCase(movieRepository: MovieRepository) =
        GetPopularMoviesUseCase(movieRepository)
}