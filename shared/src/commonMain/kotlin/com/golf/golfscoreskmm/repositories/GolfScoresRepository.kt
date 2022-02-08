package com.golf.golfscoreskmm.repositories

import com.apollographql.apollo3.ApolloClient
import com.golf.golfscoreskmm.dtos.GetScoresQuery

class GolfScoresRepository(private val apolloClient: ApolloClient) {

    suspend fun getScores(time: String): List<GetScoresQuery.Score> {
        val response = apolloClient.query(GetScoresQuery(time)).execute()
        return response.dataAssertNoErrors.scores
    }

}
