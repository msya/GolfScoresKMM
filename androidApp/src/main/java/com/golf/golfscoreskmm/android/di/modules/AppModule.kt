package com.golf.golfscoreskmm.android.di.modules

import com.golf.golfscoreskmm.android.di.scopes.AppScope
import com.golf.golfscoreskmm.android.di.scopes.SingleIn
import com.golf.golfscoreskmm.di.TournamentFactory
import com.golf.golfscoreskmm.simulator.scores.TournamentSimulator
import com.golf.golfscoreskmm.simulator.weather.WeatherSimulator
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides

@Module
@ContributesTo(AppScope::class)
object AppModule {

    @SingleIn(AppScope::class)
    @Provides
    fun provideTournamentSimulator(): TournamentSimulator =
        TournamentFactory.createRoundSimulator()

    @SingleIn(AppScope::class)
    @Provides
    fun provideWeatherSimulator(): WeatherSimulator =
        TournamentFactory.createWeatherSimulator()

}
