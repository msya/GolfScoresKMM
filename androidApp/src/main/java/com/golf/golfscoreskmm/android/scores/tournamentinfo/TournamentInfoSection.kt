package com.golf.golfscoreskmm.android.scores.tournamentinfo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.golf.golfscoreskmm.dtos.GetTournamentInfoQuery

@ExperimentalFoundationApi
@Composable
fun TournamentInfoSection(tournamentInfoModel: TournamentInfoModel) {
    when (tournamentInfoModel) {
        TournamentInfoModel.Loading ->
            CircularProgressIndicator()

        is TournamentInfoModel.Success ->
            TournamentInfoView(tournamentInfo = tournamentInfoModel.tournamentInfo)

        is TournamentInfoModel.Error ->
            Text(text = stringResource(id = tournamentInfoModel.errorStringRes))
    }
}

@Composable
fun TournamentInfoView(tournamentInfo: GetTournamentInfoQuery.TournamentInfo) {
    Column(modifier = Modifier.padding(top = 16.dp, start = 8.dp, bottom = 16.dp)) {
        Image(
            painter = rememberImagePainter(tournamentInfo.logo),
            contentDescription = null,
            modifier = Modifier.padding(16.dp)
        )
        Text(text = tournamentInfo.name, Modifier.padding(start = 16.dp), fontSize = 30.sp)
        Text(text = tournamentInfo.date, Modifier.padding(start = 16.dp, top = 16.dp), fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTournamentInfoView() {
    val data = GetTournamentInfoQuery.TournamentInfo(
        "Masters Tournament",
        "Saturday April 11 - Sunday April 14, 2019",
        "https://picsum.photos/id/237/200/300"
    )
    TournamentInfoView(data)
}
