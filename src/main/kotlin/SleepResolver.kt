package com.github.lindsaygelle

interface SleepResolver : Resolver,
    SleepLimiter,
    SleepToggler {
    var sleepResolutionMaximum: Int
    var sleepResolutionMinimum: Int
    val sleepResolutionRange: IntRange
        get() = (sleepResolutionMinimum..sleepResolutionMaximum)
    val sleepResolutionRandom: Int
        get() = sleepResolutionRange.random()
}