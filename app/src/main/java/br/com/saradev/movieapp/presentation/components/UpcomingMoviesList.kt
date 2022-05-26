package br.com.saradev.movieapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.saradev.movieapp.presentation.navigation.Actions
import br.com.saradev.movieapp.presentation.navigation.Routes
import br.com.saradev.movieapp.ui.theme.movieFontFamily
import coil.compose.rememberImagePainter

@Composable
fun UpcomingMoviesList(
    actions: Actions,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)
    ) {
        Text(
            text = "Upcoming Movies",
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
            item {
                UpcomingMoviesItem(actions)
                UpcomingMoviesItem(actions)
                UpcomingMoviesItem(actions)
                UpcomingMoviesItem(actions)
                UpcomingMoviesItem(actions)
            }
        }
    }
}

@Composable
fun UpcomingMoviesItem(
    actions: Actions,
) {
    Column(
        modifier = Modifier
            .padding(end = 10.dp)
            .width(130.dp)
            .clickable { actions.actionDetails.invoke(Routes.Details.route) }
    ) {
        Image(
            painter = rememberImagePainter(
                data = "https://m.media-amazon.com/images/M/MV5BMTc1NjIzODAxMF5BMl5BanBnXkFtZTgwMTgzNzk1NzM@._V1_.jpg"
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
            text = "Good Boys",
            style = TextStyle(
                color = MaterialTheme.colors.primary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = movieFontFamily
            )
        )
    }
}
