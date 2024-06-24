package com.garif.testapplication.task4.factory

import com.garif.testapplication.task4.model.manual.CarManual
import com.garif.testapplication.task4.model.manual.Manual
import com.garif.testapplication.task4.model.vehicles.Car
import com.garif.testapplication.task4.model.vehicles.Mechanism

class CarFactory : Factory {
    override fun createMechanism(): Mechanism = Car()

    override fun createManual(): Manual = CarManual()
}