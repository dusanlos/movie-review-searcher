package com.example.madlevel6task2.ui

import androidx.annotation.StringRes
import com.example.madlevel6task2.R

sealed class MoviesScreens(val route: String, @StringRes val labelResourceId: Int) {
    object OverviewScreen : MoviesScreens("movieOverview", R.string.overview)
    object DetailScreen : MoviesScreens("movieDetail", R.string.detail)
}
