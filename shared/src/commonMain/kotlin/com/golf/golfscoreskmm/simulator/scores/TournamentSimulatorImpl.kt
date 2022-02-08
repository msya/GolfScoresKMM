package com.golf.golfscoreskmm.simulator.scores

import com.golf.golfscoreskmm.CFlow
import com.golf.golfscoreskmm.dtos.GetPlayersQuery
import com.golf.golfscoreskmm.dtos.GetScoresQuery
import com.golf.golfscoreskmm.dtos.GetTournamentInfoQuery
import com.golf.golfscoreskmm.repositories.GolfScoresRepository
import com.golf.golfscoreskmm.repositories.PlayersRepository
import com.golf.golfscoreskmm.repositories.TournamentInfoRepository
import com.golf.golfscoreskmm.simulator.TimeSimulator
import com.golf.golfscoreskmm.wrap
import kotlinx.coroutines.flow.*

class TournamentSimulatorImpl(
    private val timeSimulator: TimeSimulator,
    private val golfScoresRepository: GolfScoresRepository,
    private val playersRepository: PlayersRepository,
    private val tournamentInfoRepository: TournamentInfoRepository
) : TournamentSimulator {

    override fun simulate(speed: Int): CFlow<Result<List<GetScoresQuery.Score>>> {
        timeSimulator.simulateTime(speed)
        return timeSimulator.timeFlow
            .map {
                Result.success(golfScoresRepository.getScores(it.toString()))
            }.catch {
                emit(Result.failure(it))
            }.wrap()
    }

    override fun getTournamentInfo(): CFlow<Result<GetTournamentInfoQuery.TournamentInfo>> =
        flow {
            val result = Result.runCatching {
                tournamentInfoRepository.getTournamentInfo()
            }
            emit(result)
        }.wrap()

    override fun getPlayers(): CFlow<Result<List<GetPlayersQuery.Player>>> =
        flow {
            val result = Result.runCatching {
                playersRepository.getPlayers()
            }
            emit(result)
        }.wrap()
}
