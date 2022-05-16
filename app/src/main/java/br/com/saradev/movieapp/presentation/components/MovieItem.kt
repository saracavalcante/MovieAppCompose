package br.com.saradev.movieapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.saradev.movieapp.R
import br.com.saradev.movieapp.data_remote.model.Movie
import br.com.saradev.movieapp.data_remote.utils.ApiConstants
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MovieItem(
    movie: Movie,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
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
        Column {
            Text(
                text = movie.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Blue
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
            Text(
                text = movie.overview,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Black
                ),
                maxLines = 4,
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
            )
            Row(
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = null,
                    tint = Color.Red
                )
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = movie.vote_average,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                )
            }
        }
    }
}