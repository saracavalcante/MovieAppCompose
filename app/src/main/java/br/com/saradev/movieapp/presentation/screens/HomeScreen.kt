package br.com.saradev.movieapp.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.saradev.movieapp.R
import br.com.saradev.movieapp.data_remote.model.Movie
import br.com.saradev.movieapp.presentation.components.PopularMovieItem
import br.com.saradev.movieapp.presentation.components.UpcomingMoviesList
import br.com.saradev.movieapp.presentation.navigation.Actions
import br.com.saradev.movieapp.presentation.viewmodel.MovieViewModel
import br.com.saradev.movieapp.ui.theme.movieFontFamily
import br.com.saradev.movieapp.utils.Status

@Composable
fun HomeScreen(
    actions: Actions,
    viewModel: MovieViewModel = hiltViewModel(),
) {
    viewModel.getUpcomingMovies("71f2a5e501cd9c5855b78f94012a33f4")
    val upcomingMovies = arrayListOf<Movie>()

    val upcomingMoviesResult = viewModel.upcomingMovies.collectAsState().value
    when (upcomingMoviesResult.status) {
        Status.LOADING -> {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
        Status.SUCCESS -> {
            upcomingMoviesResult.data?.results?.let {
                upcomingMovies.addAll(it)
                viewModel.getPopularMovies("71f2a5e501cd9c5855b78f94012a33f4")
            }
        }
        Status.EMPTY -> {
            Text(
                text = "No Upcoming Movies found...",
                modifier = Modifier.wrapContentSize(Alignment.Center),
                fontFamily = movieFontFamily,
                color = Color.Gray
            )
        }
        Status.ERROR -> {
            Text(
                text = "${upcomingMoviesResult.message}",
                modifier = Modifier.wrapContentSize(Alignment.Center),
                fontFamily = movieFontFamily,
                color = Color.Gray
            )
        }
    }

    val popularMovies = viewModel.popularMovies.collectAsState().value
    when (popularMovies.status) {
        Status.SUCCESS -> {
            popularMovies.data?.results?.let { popularMovies ->
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxHeight()
                            .absolutePadding(
                                top = 32.dp,
                                left = 32.dp,
                                right = 32.dp
                            )
                    ) {
                        item {
                            AppTopSection()
                            Spacer(modifier = Modifier.padding(top = 10.dp))
                            SearchMovie()
                            UpcomingMoviesList(actions, upcomingMovies)
                        }
                        item {
                            Spacer(modifier = Modifier.padding(top = 30.dp))
                            Text(
                                text = "Popular Movies",
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = movieFontFamily
                                )
                            )
                        }
                        itemsIndexed(popularMovies) { _: Int, item: Movie ->
                            PopularMovieItem(actions = actions, movie = item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AppTopSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = TextStyle(
                color = MaterialTheme.colors.primary,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = movieFontFamily
            )
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = null,
            tint = MaterialTheme.colors.primary
        )
    }
}

@Composable
fun SearchMovie() {
    val query: MutableState<String> = remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(50.dp),
        elevation = 0.dp,
        border = BorderStroke(
            width = 1.dp,
            color = Color.Gray
        )
    ) {
        OutlinedTextField(
            value = query.value,
            onValueChange = { query.value = it },
            placeholder = {
                Text(
                    text = "Search",
                    color = Color.Gray,
                    fontFamily = movieFontFamily
                )
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Gray
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}