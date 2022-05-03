package br.com.saradev.movieapp.di

import br.com.saradev.movieapp.data.remote.MovieRemoteDataSource
import br.com.saradev.movieapp.data.repository.MovieRepositoryImpl
import br.com.saradev.movieapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMoviesRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
    ): MovieRepository =
        MovieRepositoryImpl(movieRemoteDataSource)

}