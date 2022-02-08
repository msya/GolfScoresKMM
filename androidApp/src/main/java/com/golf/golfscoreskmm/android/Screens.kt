package com.golf.golfscoreskmm.android

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Groups
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector, @StringRes val resourceId: Int) {
    object Scores : Screen("Scores", Icons.Default.Analytics, R.string.scores_bottom_nav_title)
    object Players : Screen("Players", Icons.Default.Groups, R.string.players_bottom_nav_title)
    object Weather : Screen("Weather", Icons.Default.Cloud, R.string.weather_bottom_nav_title)
}
