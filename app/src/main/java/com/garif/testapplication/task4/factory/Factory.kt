package com.garif.testapplication.task4.factory

import com.garif.testapplication.task4.model.manual.Manual
import com.garif.testapplication.task4.model.vehicles.Mechanism

interface Factory {
    fun createMechanism(): Mechanism

    fun createManual(): Manual
}