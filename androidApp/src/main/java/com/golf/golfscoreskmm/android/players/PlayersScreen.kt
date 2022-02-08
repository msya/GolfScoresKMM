package com.golf.golfscoreskmm.android.players

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.golf.golfscoreskmm.android.R
import kotlinx.coroutines.flow.StateFlow

@ExperimentalFoundationApi
@Composable
fun PlayersScreen(model: PlayersModel) {
    when (model) {
        PlayersModel.Loading -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }
        is PlayersModel.Success ->
            Column {
                Text(
                    text = stringResource(id = R.string.players_bottom_nav_title),
                    modifier = Modifier.padding(16.dp),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
                PlayersListView(players = (model as PlayersModel.Success).players)
            }
        is PlayersModel.Error -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(id = (model as PlayersModel.Error).errorStringRes))
            }
        }
    }
}
