package com.golf.golfscoreskmm.android.scores.tournamentinfo

import androidx.annotation.StringRes
import com.golf.golfscoreskmm.dtos.GetTournamentInfoQuery

sealed interface TournamentInfoModel {

    object Loading: TournamentInfoModel

    data class Success(
        val tournamentInfo: GetTournamentInfoQuery.TournamentInfo
    ): TournamentInfoModel

    data class Error(@StringRes val errorStringRes: Int): TournamentInfoModel

}
