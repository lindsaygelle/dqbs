package com.github.lindsaygelle

interface SleepResister: Receiver {
    var sleepResistanceMaximum: Int
    var sleepResistanceMinimum: Int
    val sleepResistanceRange: IntRange
        get() = (sleepResistanceMinimum..sleepResistanceMaximum)
}