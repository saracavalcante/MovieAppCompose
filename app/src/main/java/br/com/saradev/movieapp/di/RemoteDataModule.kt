package br.com.saradev.movieapp.di

import br.com.saradev.movieapp.data.remote.MovieRemoteDataSource
import br.com.saradev.movieapp.data_remote.datasource.MovieRemoteDataSouceImpl
import br.com.saradev.movieapp.data_remote.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideMoviesRemoteDataSource(movieService: MovieService): MovieRemoteDataSource =
        MovieRemoteDataSouceImpl(movieService)
}