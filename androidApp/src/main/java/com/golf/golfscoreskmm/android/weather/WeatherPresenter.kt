package com.golf.golfscoreskmm.android.weather

import androidx.compose.runtime.*
import com.golf.golfscoreskmm.android.R
import com.golf.golfscoreskmm.android.architecture.MoleculePresenter
import com.golf.golfscoreskmm.dtos.GetScoresQuery
import com.golf.golfscoreskmm.dtos.GetTournamentInfoQuery
import com.golf.golfscoreskmm.dtos.GetWeatherQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class WeatherPresenter @Inject constructor() :
    MoleculePresenter<Result<GetWeatherQuery.Weather>, WeatherModel> {

    @Composable
    override fun present(weatherFlow: Flow<Result<GetWeatherQuery.Weather>>): WeatherModel {

        var weatherModel: WeatherModel by remember { mutableStateOf(WeatherModel.Loading) }

        LaunchedEffect(Unit) {
            weatherFlow.collect {
                println(it)
                it.fold( { weather ->
                    weatherModel = WeatherModel.Success(weather)
                }) {
                    weatherModel = WeatherModel.Error(R.string.error_loading_weather)
                }
            }
        }

        return weatherModel
    }

}
