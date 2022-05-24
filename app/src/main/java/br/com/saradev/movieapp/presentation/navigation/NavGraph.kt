package br.com.saradev.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.saradev.movieapp.presentation.screens.DetailsScreen
import br.com.saradev.movieapp.presentation.screens.HomeScreen
import br.com.saradev.movieapp.presentation.viewmodel.MovieDetailViewModel
import br.com.saradev.movieapp.presentation.viewmodel.MovieViewModel

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val actions = remember(navController) {
        Actions(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route) {
            val viewModel: MovieViewModel = viewModel(
                factory = HiltViewModelFactory(LocalContext.current, it)
            )

            HomeScreen(actions)
        }

        composable(
            "${Routes.Details.route}/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) {
            val viewModel = hiltViewModel<MovieDetailViewModel>()
            DetailsScreen(
                viewModel, actions.back,
                it.arguments?.getString("movieId") ?: ""
            )
        }
    }
}

class Actions(navController: NavController) {
    var back: () -> Unit = {
        navController.navigateUp()
    }

    var actionDetails: (String) -> Unit = { movieId ->
        navController.navigate("${Routes.Details.route}/$movieId")
    }
}