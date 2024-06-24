package com.garif.testapplication.task4.builder

import com.garif.testapplication.task4.model.vehicles.Car

class CarBuilder : Builder {
    private var car: Car = Car()

    override fun reset() {
        car = Car()
    }

    override fun setSeats(countOfSeats: Int) {
        car.seats = countOfSeats
    }

    override fun setEngine(engine: String) {
        car.engine = engine
    }

    override fun setTripComputer(tripComputer: String) {
        car.tripComputer = tripComputer
    }

    override fun setGps(gps: String) {
        car.gps = gps
    }

    fun getResult() = car
}