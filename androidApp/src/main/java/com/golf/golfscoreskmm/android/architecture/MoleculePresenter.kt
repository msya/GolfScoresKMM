package com.golf.golfscoreskmm.android.architecture

import androidx.compose.runtime.Composable
import com.golf.golfscoreskmm.dtos.GetScoresQuery
import com.golf.golfscoreskmm.dtos.GetTournamentInfoQuery
import kotlinx.coroutines.flow.Flow

interface MoleculePresenter<Event, Model> {

    @Composable
    fun present(events: Flow<Event>): Model

}
