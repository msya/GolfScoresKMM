package com.golf.golfscoreskmm.di

import com.apollographql.apollo3.ApolloClient
import com.golf.golfscoreskmm.repositories.GolfScoresRepository
import com.golf.golfscoreskmm.repositories.PlayersRepository
import com.golf.golfscoreskmm.repositories.TournamentInfoRepository
import com.golf.golfscoreskmm.repositories.WeatherRepository

object RepositoryProvider {

    fun provideGolfScoreRepository(): GolfScoresRepository {
        val apolloClient = provideApolloClient()
        return GolfScoresRepository(apolloClient)
    }

    fun provideWeatherRepository(): WeatherRepository {
        val apolloClient = provideApolloClient()
        return WeatherRepository(apolloClient)
    }

    fun providePlayersRepository(): PlayersRepository {
        val apolloClient = provideApolloClient()
        return PlayersRepository(apolloClient)
    }

    fun provideTournamentInfoRepository(): TournamentInfoRepository {
        val apolloClient = provideApolloClient()
        return TournamentInfoRepository(apolloClient)
    }

    private fun provideApolloClient(): ApolloClient =
        ApolloClient.Builder()
            .serverUrl("http://192.168.1.4:8080/graphql")
            .build()

}
