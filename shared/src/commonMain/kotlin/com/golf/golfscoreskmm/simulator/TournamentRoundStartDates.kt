package com.golf.golfscoreskmm.simulator

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant

data class TournamentRoundStartDates(
    val roundOne: Instant = createDateTime("2019-04-11T13:30:00Z"),
    val roundTwo: Instant = createDateTime("2019-04-12T13:30:00Z"),
    val roundThree: Instant = createDateTime("2019-04-13T14:05:00Z"),
    val roundFour: Instant = createDateTime("2019-04-14T12:30:00Z")
)

private fun createDateTime(timestamp: String): Instant {
    return Instant.parse(timestamp)
}
