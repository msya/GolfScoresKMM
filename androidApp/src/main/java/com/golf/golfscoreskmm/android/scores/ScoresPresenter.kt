package com.golf.golfscoreskmm.android.scores

import androidx.compose.runtime.*
import com.golf.golfscoreskmm.android.architecture.MoleculePresenter
import com.golf.golfscoreskmm.android.R
import com.golf.golfscoreskmm.dtos.GetScoresQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class ScoresPresenter @Inject constructor() :
    MoleculePresenter<Result<List<GetScoresQuery.Score>>, ScoresModel> {

    @Composable
    override fun present(events: Flow<Result<List<GetScoresQuery.Score>>>): ScoresModel {

        var scoresModel: ScoresModel by remember { mutableStateOf(ScoresModel.Loading) }

        LaunchedEffect(Unit) {
            events.collect {
                it.fold( {
                    scoresModel = ScoresModel.Success(it)
                }) {
                    scoresModel = ScoresModel.Error(R.string.error_loading_scores)
                }
            }
        }

        return scoresModel
    }
}
