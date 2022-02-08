package com.golf.golfscoreskmm.repositories

import com.apollographql.apollo3.ApolloClient
import com.golf.golfscoreskmm.dtos.GetWeatherQuery

class WeatherRepository(private val apolloClient: ApolloClient) {

    suspend fun getWeather(time: String): GetWeatherQuery.Weather {
        val response = apolloClient.query(GetWeatherQuery(time)).execute()
        return response.dataAssertNoErrors.weather
    }

}
