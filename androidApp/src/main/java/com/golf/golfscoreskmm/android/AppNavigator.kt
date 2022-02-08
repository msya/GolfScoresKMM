package com.golf.golfscoreskmm.android

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.golf.golfscoreskmm.android.players.PlayersPresenter
import com.golf.golfscoreskmm.android.players.PlayersScreen
import com.golf.golfscoreskmm.android.scores.ScoresPresenter
import com.golf.golfscoreskmm.android.scores.ScoresScreen
import com.golf.golfscoreskmm.android.scores.tournamentinfo.TournamentInfoPresenter
import com.golf.golfscoreskmm.android.weather.WeatherPresenter
import com.golf.golfscoreskmm.android.weather.WeatherScreen
import com.golf.golfscoreskmm.simulator.scores.TournamentSimulator
import com.golf.golfscoreskmm.simulator.weather.WeatherSimulator

@ExperimentalFoundationApi
@Composable
fun AppNavigator(
    tournamentSimulator: TournamentSimulator,
    tournamentInfoPresenter: TournamentInfoPresenter,
    scoresPresenter: ScoresPresenter,
    playersPresenter: PlayersPresenter,
    weatherSimulator: WeatherSimulator,
    weatherPresenter: WeatherPresenter
) {

    val items = listOf(
        Screen.Scores,
        Screen.Players,
        Screen.Weather
    )
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.Scores.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Screen.Scores.route) {
                val tournamentFlow = remember { tournamentSimulator.getTournamentInfo() }
                val tournamentInfoModel = tournamentInfoPresenter.present(events = tournamentFlow)

                val scoresFlow = remember { tournamentSimulator.simulate(speed = 1000) }
                val scoresModel = scoresPresenter.present(events = scoresFlow)

                ScoresScreen(
                    tournamentInfoModel,
                    scoresModel
                )
            }
            composable(Screen.Players.route) {
                val playersFlow = remember { tournamentSimulator.getPlayers() }
                val playersModel = playersPresenter.present(events = playersFlow)
                PlayersScreen(playersModel)
            }
            composable(Screen.Weather.route) {
                val weatherFlow = weatherSimulator.simulate(speed = 1000)
                val weatherModel = weatherPresenter.present(weatherFlow)
                WeatherScreen(weatherModel)
            }
        }
    }
}
