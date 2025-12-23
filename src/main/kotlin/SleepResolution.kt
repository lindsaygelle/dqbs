package com.github.lindsaygelle

class SleepResolution(
    resolved: Boolean,
    sleepResolutionRandom: Int,
    timeMilliseconds: Long,
    turnsSleep: Int,
) : Resolution(
    resolved, timeMilliseconds
),
    SleepAccumulator {
    var sleepResolutionRandom: Int = sleepResolutionRandom
        set(value) {
            field = value
            logger.trace("sleepResolutionRandom={}", field)
        }
    override var turnsSleep: Int = turnsSleep
        set(value) {
            field = value
            logger.trace("turnsSleep={}", value)
        }

    init {
        this.sleepResolutionRandom = sleepResolutionRandom
        this.turnsSleep = turnsSleep
    }
}