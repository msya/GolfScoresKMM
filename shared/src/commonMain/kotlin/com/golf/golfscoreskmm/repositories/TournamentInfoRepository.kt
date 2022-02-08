package com.golf.golfscoreskmm.repositories

import com.apollographql.apollo3.ApolloClient
import com.golf.golfscoreskmm.dtos.GetScoresQuery
import com.golf.golfscoreskmm.dtos.GetTournamentInfoQuery
import com.golf.golfscoreskmm.dtos.GetWeatherQuery

class TournamentInfoRepository(private val apolloClient: ApolloClient) {

    suspend fun getTournamentInfo(): GetTournamentInfoQuery.TournamentInfo {
        val response = apolloClient.query(GetTournamentInfoQuery()).execute()
        return response.dataAssertNoErrors.tournamentInfo
    }

}
