package com.golf.golfscoreskmm.android.weather

import androidx.annotation.StringRes
import com.golf.golfscoreskmm.android.scores.ScoresModel
import com.golf.golfscoreskmm.dtos.GetWeatherQuery

sealed interface WeatherModel {

    object Loading: WeatherModel

    data class Success(
        val weather: GetWeatherQuery.Weather?,
    ): WeatherModel

    data class Error(@StringRes val errorStringRes: Int): WeatherModel
}
