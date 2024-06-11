package com.garif.testapplication.task2

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// В App использование делегата
class LaunchTimeDelegate : ReadWriteProperty<Any, Long> {
    private var cachedTime: Long = System.currentTimeMillis()
    override fun getValue(thisRef: Any, property: KProperty<*>): Long {
        return cachedTime
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Long) {
        cachedTime = value
    }
}