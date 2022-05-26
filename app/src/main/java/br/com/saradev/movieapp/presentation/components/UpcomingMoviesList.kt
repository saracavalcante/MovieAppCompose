package br.com.saradev.movieapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.saradev.movieapp.R
import br.com.saradev.movieapp.data_remote.model.Movie
import br.com.saradev.movieapp.data_remote.utils.ApiConstants
import br.com.saradev.movieapp.presentation.navigation.Actions
import br.com.saradev.movieapp.presentation.navigation.Routes
import br.com.saradev.movieapp.ui.theme.movieFontFamily
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@Composable
fun UpcomingMoviesList(
    actions: Actions,
    upcomingMovies: List<Movie>,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.upcoming_movies),
            style = TextStyle(
                color = Color.Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = movieFontFamily
            )
        )
        LazyRow(
            modifier = Modifier.padding(top = 15.dp)
        ) {
            itemsIndexed(upcomingMovies) { _: Int, item: Movie ->
                UpcomingMoviesItem(actions = actions, movie = item)
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun UpcomingMoviesItem(
    actions: Actions,
    movie: Movie,
) {
    Column(
        modifier = Modifier
            .padding(end = 10.dp)
            .width(130.dp)
            .clickable { actions.actionDetails.invoke(Routes.Details.route) }
    ) {
        Image(
            painter = rememberImagePainter(
                data = ApiConstants.POSTER_URL + movie.poster_path
            ),
            contentDescription = null,
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Text(
            text = movie.title,
            style = TextStyle(
                color = MaterialTheme.colors.primary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = movieFontFamily
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
