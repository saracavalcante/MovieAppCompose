package br.com.saradev.movieapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.saradev.movieapp.data_remote.model.Movie
import br.com.saradev.movieapp.data_remote.utils.ApiConstants
import br.com.saradev.movieapp.presentation.navigation.Actions
import br.com.saradev.movieapp.presentation.navigation.Routes
import br.com.saradev.movieapp.ui.theme.movieFontFamily
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PopularMovieItem(
    actions: Actions,
    movie: Movie,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)
            .clickable {
                actions.actionDetails.invoke(Routes.Details.route)
            }
    ) {
        Image(
            painter = rememberImagePainter(
                data = ApiConstants.POSTER_URL + movie.poster_path
            ),
            contentDescription = null,
            modifier = Modifier
                .height(140.dp)
                .width(100.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .padding(start = 20.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = movie.title,
                style = TextStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = movieFontFamily
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color.Yellow,
                    modifier = Modifier
                        .size(24.dp)
                )
                Text(
                    text = movie.vote_average,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontFamily = movieFontFamily
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Chip(movie)
        }
    }
}

@Composable
fun Chip(
    movie: Movie,
) {
    Row {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Gray.copy(.10F))
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = 5.dp,
                    bottom = 5.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = movie.release_date,
                style = TextStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 12.sp,
                    fontFamily = movieFontFamily
                )
            )
        }

        Spacer(modifier = Modifier.size(10.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Gray.copy(.10F))
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = 5.dp,
                    bottom = 5.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = movie.original_language,
                style = TextStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 12.sp,
                    fontFamily = movieFontFamily
                )
            )
        }
    }
}