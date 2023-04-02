package com.example.madlevel6task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.madlevel6task2.ui.screens.DetailScreen
import com.example.madlevel6task2.ui.screens.MoviesScreens
import com.example.madlevel6task2.ui.screens.OverviewScreen
import com.example.madlevel6task2.ui.theme.MadLevel6Task2Theme
import com.example.madlevel6task2.viewmodel.MovieViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MadLevel6Task2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Level6Task2App()
                }
            }
        }
    }
}

@Composable
fun Level6Task2App() {
    val navController = rememberNavController()

    Scaffold(

    ) { innerPadding ->
        NavHostScreen(navController, innerPadding)
    }

}

@Composable
private fun NavHostScreen(
    navController: NavHostController,
    innerPadding: PaddingValues,
    viewModel: MovieViewModel = viewModel()
) {
    NavHost(
        navController,
        startDestination = MoviesScreens.OverviewScreen.route,
        Modifier.padding(innerPadding)
    ) {
        composable( MoviesScreens.OverviewScreen.route,) {
            OverviewScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable(MoviesScreens.DetailScreen.route) {
            DetailScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}
