package com.golf.golfscoreskmm.android.players

import androidx.annotation.StringRes
import com.golf.golfscoreskmm.dtos.GetPlayersQuery
import com.golf.golfscoreskmm.dtos.GetScoresQuery
import com.golf.golfscoreskmm.dtos.GetTournamentInfoQuery

sealed interface PlayersModel {

    object Loading: PlayersModel

    data class Success(
        val players: List<GetPlayersQuery.Player>
    ): PlayersModel

    data class Error(@StringRes val errorStringRes: Int): PlayersModel
}
