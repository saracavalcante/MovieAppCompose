package br.com.saradev.movieapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.saradev.movieapp.R

// Set of Material typography styles to start with
val movieFontFamily = FontFamily(
    Font(R.font.poppins, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_bold, FontWeight.Bold),
)

val AppTypography = Typography(
    h1 = TextStyle(
        fontFamily = movieFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp
    ),
    h2 = TextStyle(
        fontFamily = movieFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = movieFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = movieFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)