package br.com.saradev.movieapp.presentation.navigation

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Details : Routes("details")
}