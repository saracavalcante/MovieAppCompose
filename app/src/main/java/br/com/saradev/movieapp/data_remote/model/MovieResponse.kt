package br.com.saradev.movieapp.data_remote.model

data class MovieResponse(
    val results: List<Movie>,
)

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val vote_average: String,
    val poster_path: String,
    val backdrop_path: String,
    val release_date: String,
    val original_language: String
)