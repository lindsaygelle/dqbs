package com.github.lindsaygelle

import java.util.UUID

class SleepResolution(
    resolved: Boolean,
    sleepResolutionRandom: Int,
    timeMilliseconds: Long,
    turnsSleep: Int,
    uuid: UUID,
) : Resolution(
    resolved, timeMilliseconds, uuid
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

    override fun toString(): String {
        return "sleepResolutionRandom=${sleepResolutionRandom} turnsSleep=${turnsSleep} ${super.toString()}"
    }
}
