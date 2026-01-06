package com.github.lindsaygelle

interface SleepResister : Receiver {
    val sleepResistance: Int
        get() = sleepResistanceRange.random()
    var sleepResistanceMaximum: Int
    var sleepResistanceMinimum: Int
    val sleepResistanceRange: IntRange
        get() = (sleepResistanceMinimum..sleepResistanceMaximum)
}