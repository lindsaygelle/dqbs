package com.github.lindsaygelle

class SleepResolution(resolved: Boolean, sleepResolutionRandom: Int, timeMilliseconds: Long) :
    Resolution(resolved, timeMilliseconds) {
    var sleepResolutionRandom: Int = sleepResolutionRandom
        set(value) {
            field = value
            logger.trace("sleepResolutionRandom={}", field)
        }

    init {
        this.sleepResolutionRandom = sleepResolutionRandom
    }
}