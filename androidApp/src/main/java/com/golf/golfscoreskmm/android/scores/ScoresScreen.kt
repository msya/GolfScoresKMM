package com.golf.golfscoreskmm.android.scores

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.golf.golfscoreskmm.android.scores.tournamentinfo.TournamentInfoModel
import com.golf.golfscoreskmm.android.scores.tournamentinfo.TournamentInfoSection

@ExperimentalFoundationApi
@Composable
fun ScoresScreen(
    tournamentInfoModel: TournamentInfoModel,
    scoresModel: ScoresModel
) {
    Column {
        TournamentInfoSection(tournamentInfoModel = tournamentInfoModel)
        ScoresSection(scoresModel)
    }
}
