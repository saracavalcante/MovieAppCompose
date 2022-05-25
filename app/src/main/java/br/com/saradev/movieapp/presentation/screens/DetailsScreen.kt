package br.com.saradev.movieapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.saradev.movieapp.R
import br.com.saradev.movieapp.ui.theme.movieFontFamily
import coil.compose.rememberImagePainter

@Composable
fun DetailScreen(
    back: () -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        topBar = {
            MovieAppBar(back)
        }
    ) {
        LazyColumn {
            item {
                MovieDetails()
                CastDetails()
            }
        }
    }
}

@Composable
fun CastDetails() {
    Text(
        text = stringResource(id = R.string.cast),
        style = TextStyle(
            color = Color.Gray,
            fontSize = 18.sp,
            fontFamily = movieFontFamily,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier
            .padding(start = 32.dp, top = 20.dp)
    )
    Spacer(modifier = Modifier.size(10.dp))
    LazyRow(
        modifier = Modifier
            .padding(top = 5.dp, start = 32.dp, end = 32.dp)
    ) {
        item {
            CastItem()
            CastItem()
            CastItem()
            CastItem()
        }
    }
    Spacer(modifier = Modifier.padding(bottom = 32.dp))
}

@Composable
fun CastItem() {
    Column(
        modifier = Modifier
            .padding(end = 10.dp)
            .width(80.dp)
    ) {
        Image(
            painter = rememberImagePainter(data = "https://image.tmdb.org/t/p/w185/ca3x0OfIKbJppZh8S1Alx3GfUZO.jpg"),
            contentDescription = null,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Text(
            text = "Ator A",
            style = TextStyle(
                fontFamily = movieFontFamily,
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun MovieDetails() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, end = 32.dp),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = rememberImagePainter(
                data = "https://m.media-amazon.com/images/M/MV5BMTc1NjIzODAxMF5BMl5BanBnXkFtZTgwMTgzNzk1NzM@._V1_.jpg"
            ),
            contentDescription = null,
            modifier = Modifier
                .width(215.dp)
                .height(365.dp)
                .padding(top = 32.dp)
                .clip(RoundedCornerShape(30.dp))
                .align(CenterHorizontally),
            contentScale = ContentScale.FillBounds,
        )
        Text(
            text = "Good Boys",
            style = TextStyle(
                color = MaterialTheme.colors.primary,
                fontSize = 24.sp,
                fontFamily = movieFontFamily,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.padding(top = 20.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Vote()
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = "05-02-2020",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 12.sp,
                    fontFamily = movieFontFamily
                )
            )
        }
        Spacer(modifier = Modifier.size(30.dp))
        Text(
            text = "Na esperança de aprender a beijar, Max decide usar o drone de seu pai para espionar as garotas da vizinhança. As coisas não saem como o esperado, então Max e seus amigos precisam bolar um plano de resgate ao drone antes que seu pai perceba.",
            style = TextStyle(
                color = Color.Gray,
                fontFamily = movieFontFamily,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun Vote() {
    Row(
        verticalAlignment = CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            tint = Color.Yellow,
            modifier = Modifier
                .size(24.dp)
        )
        Text(
            text = "8.9",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 12.sp,
                fontFamily = movieFontFamily
            )
        )
    }
}

@Composable
fun MovieAppBar(
    back: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.movie_details),
                style = TextStyle(
                    fontFamily = movieFontFamily,
                    color = Color.Gray,
                    fontSize = 18.sp
                )
            )
        },
        backgroundColor = Color.White,
        elevation = 0.dp,
        navigationIcon = {
            IconButton(
                onClick = { back.invoke() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }
    )
}

@Preview
@Composable
fun CastItemPreview() {
    DetailScreen(back = {})
}