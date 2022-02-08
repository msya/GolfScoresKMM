package com.golf.golfscoreskmm.android.players

import androidx.compose.runtime.*
import com.golf.golfscoreskmm.android.R
import com.golf.golfscoreskmm.android.architecture.MoleculePresenter
import com.golf.golfscoreskmm.dtos.GetPlayersQuery
import com.golf.golfscoreskmm.dtos.GetScoresQuery
import com.golf.golfscoreskmm.dtos.GetTournamentInfoQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class PlayersPresenter @Inject constructor(): MoleculePresenter<Result<List<GetPlayersQuery.Player>>, PlayersModel>  {

    @Composable
    override fun present(events: Flow<Result<List<GetPlayersQuery.Player>>>): PlayersModel {

        var playersModel: PlayersModel by remember { mutableStateOf(PlayersModel.Loading) }

        LaunchedEffect(Unit) {
            events.collect {
                it.fold( { scores ->
                    playersModel = PlayersModel.Success(scores)
                }) {
                    playersModel = PlayersModel.Error(R.string.error_loading_players)
                }
            }
        }

        return playersModel
    }
}
