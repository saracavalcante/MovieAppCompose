package br.com.saradev.movieapp.di

import br.com.saradev.movieapp.data_remote.repository.MovieRepositoryImpl
import br.com.saradev.movieapp.data_remote.service.MovieService
import br.com.saradev.movieapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideGetPopularMoviesRepo(
        movieService: MovieService,
    ): MovieRepository {

        return MovieRepositoryImpl(movieService = movieService)
    }
}