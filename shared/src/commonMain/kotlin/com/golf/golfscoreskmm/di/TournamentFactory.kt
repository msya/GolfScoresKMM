package com.golf.golfscoreskmm.di

import com.golf.golfscoreskmm.simulator.scores.TournamentSimulator
import com.golf.golfscoreskmm.simulator.scores.TournamentSimulatorImpl
import com.golf.golfscoreskmm.simulator.weather.WeatherSimulator
import com.golf.golfscoreskmm.simulator.weather.WeatherSimulatorImpl

object TournamentFactory {

    fun createRoundSimulator(): TournamentSimulator {
        val scoresRepo = RepositoryProvider.provideGolfScoreRepository()
        val tournamentInfoRepo= RepositoryProvider.provideTournamentInfoRepository()
        val playersRepository = RepositoryProvider.providePlayersRepository()

        val simulator = TimeSimulatorProvider.providesTimeSimulator()

        return TournamentSimulatorImpl(
            simulator,
            scoresRepo,
            playersRepository,
            tournamentInfoRepo
        )
    }

    fun createWeatherSimulator(): WeatherSimulator {
        val repo = RepositoryProvider.provideWeatherRepository()
        val simulator = TimeSimulatorProvider.providesTimeSimulator()

        return WeatherSimulatorImpl(
            simulator,
            repo
        )
    }
}
