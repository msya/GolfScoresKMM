package com.golf.golfscoreskmm.repositories

import com.apollographql.apollo3.ApolloClient
import com.golf.golfscoreskmm.dtos.GetPlayersQuery
import com.golf.golfscoreskmm.dtos.GetScoresQuery
import com.golf.golfscoreskmm.dtos.GetTournamentInfoQuery
import com.golf.golfscoreskmm.dtos.GetWeatherQuery

class PlayersRepository(private val apolloClient: ApolloClient) {

    suspend fun getPlayers(): List<GetPlayersQuery.Player> {
        val response = apolloClient.query(GetPlayersQuery()).execute()
        return response.dataAssertNoErrors.players
    }

}
