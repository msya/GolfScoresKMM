package com.golf.golfscoreskmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import app.cash.molecule.AndroidUiDispatcher.Companion.Main
import app.cash.molecule.launchMolecule
import com.golf.golfscoreskmm.android.players.PlayersPresenter
import com.golf.golfscoreskmm.android.scores.ScoresPresenter
import com.golf.golfscoreskmm.android.scores.tournamentinfo.TournamentInfoPresenter
import com.golf.golfscoreskmm.android.theme.GolfScoresAppTheme
import com.golf.golfscoreskmm.android.weather.WeatherPresenter
import com.golf.golfscoreskmm.simulator.scores.TournamentSimulator
import com.golf.golfscoreskmm.simulator.weather.WeatherSimulator
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var tournamentSimulator: TournamentSimulator

    @Inject
    lateinit var weatherSimulator: WeatherSimulator

    @Inject
    lateinit var tournamentInfoPresenter: TournamentInfoPresenter

    @Inject
    lateinit var scoresPresenter: ScoresPresenter

    @Inject
    lateinit var weatherPresenter: WeatherPresenter

    @Inject
    lateinit var playersPresenter: PlayersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        GolfScoresApp.component.inject(this)
        super.onCreate(savedInstanceState)

        setContent {
            GolfScoresAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    AppNavigator(
                        tournamentSimulator,
                        tournamentInfoPresenter,
                        scoresPresenter,
                        playersPresenter,
                        weatherSimulator,
                        weatherPresenter
                    )
                }
            }
        }
    }
}
