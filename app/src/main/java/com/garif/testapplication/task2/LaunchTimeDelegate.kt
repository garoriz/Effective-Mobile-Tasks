package com.garif.testapplication.task2

import android.util.LruCache
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private const val LAUNCH_TIME = "launch_time"

// В App использование делегата
class LaunchTimeDelegate(memoryCache: LruCache<String, Long>) : ReadWriteProperty<Any, Long> {
    private val _memoryCache = memoryCache
    private var cachedTime: Long = System.currentTimeMillis()

    override fun getValue(thisRef: Any, property: KProperty<*>): Long {
        return cachedTime
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Long) {
        _memoryCache.put(LAUNCH_TIME, value)
        cachedTime = value
    }
}