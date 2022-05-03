package br.com.saradev.movieapp.data.repository

import br.com.saradev.movieapp.data.remote.MovieRemoteDataSource
import br.com.saradev.movieapp.data_remote.model.MovieList
import br.com.saradev.movieapp.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
) : MovieRepository {

    override suspend fun getPopularMovies() =
        responseToRequest(movieRemoteDataSource.getPopularMovies())

    private fun responseToRequest(response: Response<MovieList>): Result<MovieList> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Result.success(result)
            }
        }
        return Result.failure(Exception(response.message()))
    }
}