package com.golf.golfscoreskmm.android.scores.tournamentinfo

import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import com.golf.golfscoreskmm.android.R
import com.golf.golfscoreskmm.android.architecture.MoleculePresenter
import com.golf.golfscoreskmm.android.scores.ScoresModel
import com.golf.golfscoreskmm.android.weather.WeatherModel
import com.golf.golfscoreskmm.dtos.GetTournamentInfoQuery
import com.golf.golfscoreskmm.dtos.GetWeatherQuery
import com.golf.golfscoreskmm.simulator.scores.TournamentSimulator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class TournamentInfoPresenter @Inject constructor(): MoleculePresenter<Result<GetTournamentInfoQuery.TournamentInfo>, TournamentInfoModel> {

    @Composable
    override fun present(events: Flow<Result<GetTournamentInfoQuery.TournamentInfo>>): TournamentInfoModel {
        var model: TournamentInfoModel by remember { mutableStateOf(TournamentInfoModel.Loading) }

        LaunchedEffect(Unit) {
            events.collect {
                it.fold({
                    model = TournamentInfoModel.Success(it)
                }) {
                    model = TournamentInfoModel.Error(R.string.error_loading_tournament_info)
                }
            }
        }

        return model
    }

}
