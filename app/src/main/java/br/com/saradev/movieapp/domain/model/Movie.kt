package br.com.saradev.movieapp.domain.model

data class Movie(
    val id: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
)
