package com.github.lindsaygelle

interface SleepResolver {
    var sleepResolutionMaximum: Int
    var sleepResolutionMinimum: Int
    val sleepResolutionRange: IntRange
        get() = (sleepResolutionMinimum..sleepResolutionMaximum)
    val sleepResolutionRandom: Int
        get() = sleepResolutionRange.random()
}