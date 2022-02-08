package com.golf.golfscoreskmm.simulator.weather

import com.golf.golfscoreskmm.dtos.GetWeatherQuery
import com.golf.golfscoreskmm.repositories.WeatherRepository
import com.golf.golfscoreskmm.simulator.TimeSimulator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class WeatherSimulatorImpl(
    private val timeSimulator: TimeSimulator,
    private val weatherRepository: WeatherRepository
): WeatherSimulator {

    override fun simulate(speed: Int): Flow<Result<GetWeatherQuery.Weather>> {
        timeSimulator.simulateTime(speed)
        return timeSimulator.timeFlow
            .map {
                Result.success(weatherRepository.getWeather(it.toString()))
            }.catch {
                Result.failure<Result<GetWeatherQuery.Weather>>(it)
            }
    }

}
