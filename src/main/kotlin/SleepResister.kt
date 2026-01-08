package com.github.lindsaygelle

interface SleepResister : Receiver,
    SleepResistanceMaximizer,
    SleepResistanceMinimizer {
    val sleepResistance: Int
        get() = sleepResistanceRange.random()
    val sleepResistanceRange: IntRange
        get() = (sleepResistanceMinimum..sleepResistanceMaximum)
}