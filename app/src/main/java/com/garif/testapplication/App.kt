package com.garif.testapplication

import android.app.Application
import android.util.LruCache
import com.garif.testapplication.task2.LaunchTimeDelegate
import com.garif.testapplication.task2.LogLaunchTime

class App() : Application() {
    private val memoryCache = LruCache<String, Long>(8)
    private var launchTime: Long by LaunchTimeDelegate(memoryCache)
    private lateinit var logLaunchTime: LogLaunchTime

    override fun onCreate() {
        super.onCreate()
        launchTime = System.currentTimeMillis() - launchTime
        logLaunchTime = LogLaunchTime(memoryCache)
    }

    override fun onTerminate() {
        super.onTerminate()
        logLaunchTime.stopLogging()
    }
}