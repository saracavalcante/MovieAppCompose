package br.com.saradev.movieapp.domain.mappers

import br.com.saradev.movieapp.data_remote.model.Result
import br.com.saradev.movieapp.domain.model.Movie

fun List<Result>.toDomain(): List<Movie> {
    return map {
        Movie(
            id = it.id ?: "",
            overview = it.overview ?: "",
            poster_path = it.poster_path ?: "",
            release_date = it.release_date ?: "",
            title = it.title ?: ""
        )
    }
}