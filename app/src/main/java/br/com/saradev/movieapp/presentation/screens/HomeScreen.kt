package br.com.saradev.movieapp.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.saradev.movieapp.R
import br.com.saradev.movieapp.data_remote.model.Movie
import br.com.saradev.movieapp.presentation.components.MovieItem
import br.com.saradev.movieapp.presentation.viewmodel.MovieViewModel
import br.com.saradev.movieapp.utils.Status

@Composable
fun HomeScreen(
    viewModel: MovieViewModel = hiltViewModel(),
) {
    viewModel.getPopularMovies("71f2a5e501cd9c5855b78f94012a33f4")

    val popularMovies = viewModel.popularMovies.collectAsState().value
    when (popularMovies.status) {
        Status.LOADING -> {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Status.SUCCESS -> {
            popularMovies.data?.results?.let { popularMovies ->
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxHeight()
                            .absolutePadding(
                                top = 20.dp,
                                left = 20.dp,
                                right = 20.dp
                            )
                    ) {
                        item {
                            Text(
                                text = stringResource(id = R.string.popular_movies),
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            )
                        }

                        itemsIndexed(popularMovies) { _: Int, item: Movie ->
                            Spacer(modifier = Modifier
                                .padding(top = 10.dp)
                            )
                            MovieItem(movie = item)
                        }
                    }
                }
            }
        }
    }
}