package com.golf.golfscoreskmm.android.players

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.golf.golfscoreskmm.dtos.GetPlayersQuery

@Composable
fun PlayersListView(players: List<GetPlayersQuery.Player>) {
    LazyColumn {
        items(players) { player ->
            Row {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "${player.firstName} ${player.lastName}"
                )
            }
            Divider(modifier = Modifier.padding(start = 16.dp, end = 16.dp), color = Color.LightGray)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PlayersListPreview() {
    val players = listOf(
        GetPlayersQuery.Player("Tiger", "Woods"),
        GetPlayersQuery.Player("Phil", "Mickelson"),
        GetPlayersQuery.Player("Vijay", "Singh")
    )
    PlayersListView(players = players)
}
