package com.garif.testapplication.task4.builder

interface Builder {
    fun reset()

    fun setSeats(countOfSeats: Int)

    fun setEngine(engine: String)

    fun setTripComputer(tripComputer: String)

    fun setGps(gps: String)

}