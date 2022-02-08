package com.golf.golfscoreskmm.android.scores

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.golf.golfscoreskmm.android.R
import com.golf.golfscoreskmm.dtos.GetScoresQuery

private const val COLUMN_WEIGHT_20 = .2f
private const val COLUMN_WEIGHT_40 = .4f

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScoresListView(scores: List<GetScoresQuery.Score>) {
    LazyColumn {
        stickyHeader {
            Row(
                modifier = Modifier
                    .background(Color(8, 63, 119))
                    .padding(start = 16.dp)
            ) {
                ScoreHeader(text = stringResource(id = R.string.pos))
                ScoreHeader(text = stringResource(id = R.string.player), ScoreCellSize.LARGE)
                ScoreHeader(text = stringResource(id = R.string.total))
                ScoreHeader(text = stringResource(id = R.string.thru))
                ScoreHeader(text = stringResource(id = R.string.round))
            }
        }
        items(scores) { score ->
            Row(modifier = Modifier.padding(start = 16.dp)) {
                ScoreCell(text = score.position)
                ScoreCell(text = score.name, ScoreCellSize.LARGE)
                ScoreCell(text = score.tot)
                ScoreCell(text = score.thru)
                if (score.teeTime != null) {
                    ScoreCell(text = score.teeTime!!)
                } else {
                    ScoreCell(text = score.round)
                }
            }
            Divider(modifier = Modifier.padding(start = 16.dp, end = 16.dp), color = Color.LightGray)
        }
    }
}

enum class ScoreCellSize {
    LARGE,
    MEDIUM
}

@Composable
fun RowScope.ScoreHeader(
    text: String,
    size: ScoreCellSize = ScoreCellSize.MEDIUM
) {
    val weight = getWeight(size)
    Text(
        text = text,
        Modifier
            .weight(weight)
            .padding(top = 8.dp, bottom = 8.dp),
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun RowScope.ScoreCell(
    text: String,
    size: ScoreCellSize = ScoreCellSize.MEDIUM
) {
    val weight = getWeight(size)
    Text(
        text = text,
        Modifier
            .weight(weight)
            .padding(top = 8.dp, bottom = 8.dp)
    )
}

private fun getWeight(size: ScoreCellSize): Float =
    when (size) {
        ScoreCellSize.LARGE -> COLUMN_WEIGHT_40
        ScoreCellSize.MEDIUM -> COLUMN_WEIGHT_20
    }

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewScoresList() {
    val scores = listOf(
        GetScoresQuery.Score(
            name = "Tiger Woods",
            position = "1",
            round = "-2",
            teeTime = null,
            thru = "5",
            tot = "-2"
        ),
        GetScoresQuery.Score(
            name = "Vijay Singh",
            position = "T2",
            round = "-1",
            teeTime = null,
            thru = "3",
            tot = "-1"
        ),
        GetScoresQuery.Score(
            name = "Phil Mickelson",
            position = "T2",
            round = "0",
            teeTime = "1:30",
            thru = "1",
            tot = "E"
        )
    )
    ScoresListView(scores = scores)
}
