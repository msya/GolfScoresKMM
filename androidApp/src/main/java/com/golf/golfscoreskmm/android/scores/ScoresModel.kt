package com.golf.golfscoreskmm.android.scores

import androidx.annotation.StringRes
import com.golf.golfscoreskmm.dtos.GetScoresQuery
import com.golf.golfscoreskmm.dtos.GetTournamentInfoQuery

sealed interface ScoresModel {

    object Loading: ScoresModel

    data class Success(val scores: List<GetScoresQuery.Score>): ScoresModel

    data class Error(@StringRes val errorStringRes: Int): ScoresModel
}
