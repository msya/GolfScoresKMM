package com.golf.golfscoreskmm.simulator.scores

import com.golf.golfscoreskmm.CFlow
import com.golf.golfscoreskmm.dtos.GetPlayersQuery
import com.golf.golfscoreskmm.dtos.GetScoresQuery
import com.golf.golfscoreskmm.dtos.GetTournamentInfoQuery
import com.golf.golfscoreskmm.dtos.GetWeatherQuery
import com.golf.golfscoreskmm.dtos.type.TournamentInfo
import com.golf.golfscoreskmm.repositories.GolfScoresRepository
import com.golf.golfscoreskmm.repositories.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

interface TournamentSimulator {

    fun simulate(speed: Int): CFlow<Result<List<GetScoresQuery.Score>>>

    fun getTournamentInfo(): CFlow<Result<GetTournamentInfoQuery.TournamentInfo>>

    fun getPlayers(): CFlow<Result<List<GetPlayersQuery.Player>>>

}
