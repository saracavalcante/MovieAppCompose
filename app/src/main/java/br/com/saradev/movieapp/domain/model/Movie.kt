package br.com.saradev.movieapp.domain.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("poster_path")
    val poster: String,
    @SerializedName("vote_average")
    val rating: String,
    @SerializedName("release_date")
    val releaseDate: String
)
