package com.golf.golfscoreskmm.simulator.weather

import com.golf.golfscoreskmm.dtos.GetWeatherQuery
import kotlinx.coroutines.flow.Flow

interface WeatherSimulator {

    fun simulate(speed: Int): Flow<Result<GetWeatherQuery.Weather>>

}
