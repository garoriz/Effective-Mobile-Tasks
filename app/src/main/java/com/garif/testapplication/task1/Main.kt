package com.garif.testapplication.task1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(): Unit = runBlocking {
    flow {
        emit("A")
        delay(500)
        emit("B")
        delay(200)
        emit("C")
        delay(800)
        emit("D")
        delay(600)
        emit("E")
    }.throttleLatest(1, TimeUnit.SECONDS)
        .collect { println(it) }
}

fun <T> Flow<T>.throttleFirst(time: Long, timeUnit: TimeUnit): Flow<T> = flow {
    var timePeriod = 0L

    collect { value: T ->
        val currentTime = System.currentTimeMillis()
        if (currentTime - timePeriod >= timeUnit.toMillis(time)) {
            timePeriod = currentTime
            emit(value)
        }
    }
}

fun <T> Flow<T>.throttleLatest(time: Long, timeUnit: TimeUnit): Flow<T> = flow {
    var timePeriod = 0L
    var latestElem: Any? = NoValue

    collect { value: T ->
        val currentTime = System.currentTimeMillis()

        if (latestElem == NoValue)
            latestElem = value

        if (currentTime - timePeriod >= timeUnit.toMillis(time)) {
            emit(latestElem as T)
            timePeriod = currentTime - timePeriod.mod(timeUnit.toMillis(time))
        }
        latestElem = value
    }
}

private object NoValue
