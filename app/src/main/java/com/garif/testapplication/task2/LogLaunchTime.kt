package com.garif.testapplication.task2

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch


// В App использование класса
class LogLaunchTime(private val launchTime: Long) {
    private val logJob: Job = GlobalScope.launch(Dispatchers.IO) {
        while (isActive) {
            delay(3000)
            logLaunchTime()
        }
    }

    private fun logLaunchTime() {
        val launchTime = launchTime
        Log.d("LaunchTimeLogger", "Cached Launch Time: $launchTime")
    }

    fun stopLogging() {
        logJob.cancel()
    }
}