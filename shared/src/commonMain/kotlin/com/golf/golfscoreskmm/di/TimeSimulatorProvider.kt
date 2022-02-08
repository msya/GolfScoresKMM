package com.golf.golfscoreskmm.di

import com.golf.golfscoreskmm.simulator.TimeSimulator
import com.golf.golfscoreskmm.simulator.TournamentRoundStartDates

object TimeSimulatorProvider {

    fun providesTimeSimulator() =
        TimeSimulator(TournamentRoundStartDates())

}
