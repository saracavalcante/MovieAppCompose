package br.com.saradev.movieapp.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.saradev.movieapp.presentation.components.MovieItem
import br.com.saradev.movieapp.presentation.navigation.Actions
import br.com.saradev.movieapp.ui.theme.movieFontFamily

@Composable
fun HomeScreen(
    actions: Actions,
) {
    Scaffold(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp)
    ) {
        Column {
            Text(
                text = "MovieApp",
                style = TextStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = movieFontFamily
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            SearchMovie()
            Spacer(modifier = Modifier.height(32.dp))
            MovieItem(actions)

        }
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