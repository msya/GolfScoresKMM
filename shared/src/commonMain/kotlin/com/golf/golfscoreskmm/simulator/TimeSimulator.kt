package com.golf.golfscoreskmm.simulator

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.datetime.*

class TimeSimulator(private val roundStartDates: TournamentRoundStartDates) {

    private val scope = CoroutineScope(Dispatchers.Default)

    private var job: Job? = null

    val timeFlow = MutableSharedFlow<LocalDateTime>(replay = 1)

    private var dayOfMonth: Int = 0
    private var year: Int = 0
    private var month: Int = 0
    private var hour = 0
    private var minute = 0
    private var second = 0
    private var tickInterval: Long = 1000L

    fun simulateTime(speed: Int) {
        job = scope.launch {
            tickInterval = 1000L/speed

            simulateTime(
                roundStartDates.roundOne,
                roundStartDates.roundFour.plus(8, DateTimeUnit.HOUR)
            )
            simulateTime(
                roundStartDates.roundTwo,
                roundStartDates.roundTwo.plus(8, DateTimeUnit.HOUR)
            )
            simulateTime(
                roundStartDates.roundThree,
                roundStartDates.roundThree.plus(8, DateTimeUnit.HOUR)
            )
            simulateTime(
                roundStartDates.roundFour,
                roundStartDates.roundFour.plus(8, DateTimeUnit.HOUR)
            )
        }
    }

    private suspend fun simulateTime(
        startInstant: Instant,
        endInstant: Instant
    ) {
       getTimeParams(startInstant)

        var now = Clock.System.now()
        var currentDateTimeInstant = startInstant
        var wakeUpTime: Long = now.epochSeconds
        var sleepTime: Long

        while (currentDateTimeInstant < endInstant) {
            val dateTime = LocalDateTime(
                year,
                month,
                dayOfMonth,
                hour,
                minute
            )
            currentDateTimeInstant = dateTime.toInstant(TimeZone.of("EST"))
            timeFlow.emit(dateTime)

            wakeUpTime += tickInterval
            now = Clock.System.now()

            sleepTime = wakeUpTime - now.epochSeconds
            if (sleepTime > 5) {
                delay(sleepTime)
            }

            incrementTimeParams()
        }
    }

    private fun getTimeParams(startInstant: Instant) {
        val startDateTime = startInstant.toLocalDateTime(TimeZone.of("EST"))

        dayOfMonth = startDateTime.dayOfMonth
        year = startDateTime.year
        month = startDateTime.monthNumber

        second = startDateTime.second
        minute = startDateTime.minute
        hour = startDateTime.hour
    }

    private fun incrementTimeParams() {
        second++
        if (60 <= second) {
            minute++
            second = 0
        }
        if (60 <= minute) {
            hour++
            minute = 0
        }
    }


}
