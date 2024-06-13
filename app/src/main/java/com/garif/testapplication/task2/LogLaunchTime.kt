package com.garif.testapplication.task2

import android.util.Log
import android.util.LruCache
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

private const val LAUNCH_TIME = "launch_time"

// В App использование класса
class LogLaunchTime(memoryCache: LruCache<String, Long>) {
    private val _memoryCache = memoryCache
    private val logJob: Job = GlobalScope.launch(Dispatchers.IO) {
        while (isActive) {
            delay(3000)
            logLaunchTime()
        }
    }

    private fun logLaunchTime() {
        val launchTime = _memoryCache.get(LAUNCH_TIME)
        Log.d("LaunchTimeLogger", "Cached Launch Time: $launchTime")
    }

    fun stopLogging() {
        logJob.cancel()
    }
}