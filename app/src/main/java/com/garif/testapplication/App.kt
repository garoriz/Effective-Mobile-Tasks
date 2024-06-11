package com.garif.testapplication

import android.app.Application
import com.garif.testapplication.task2.LaunchTimeDelegate
import com.garif.testapplication.task2.LogLaunchTime

class App() : Application() {
    var launchTime: Long by LaunchTimeDelegate()
    private lateinit var logLaunchTime: LogLaunchTime

    override fun onCreate() {
        super.onCreate()
        launchTime = System.currentTimeMillis() - launchTime
        logLaunchTime = LogLaunchTime(launchTime)
    }

    override fun onTerminate() {
        super.onTerminate()
        logLaunchTime.stopLogging()
    }
}