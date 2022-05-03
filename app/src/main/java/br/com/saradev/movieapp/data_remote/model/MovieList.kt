package br.com.saradev.movieapp.data_remote.model

import br.com.saradev.movieapp.domain.model.Movie
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>,
) : Serializable
