package com.github.lindsaygelle

import java.util.*

class SleepCheck(
    magicPoints: Int,
    magicPointsRequirement: Int,
    sleepRequirement: Int,
    sleepResistance: Int,
    timeMilliseconds: Long,
    uuid: UUID
) : MagicCheck(
    magicPoints, magicPointsRequirement, timeMilliseconds, uuid
) {
    override val result: Boolean
        get() = (sleepRequirement >= sleepResistance) && ((magicPoints - magicPointsRequirement) >= 0)
    var sleepRequirement: Int = sleepRequirement
        set(value) {
            field = value
            logger.trace("sleepRequirement={}", field)
        }
    var sleepResistance: Int = sleepResistance
        set(value) {
            field = value
            logger.trace("sleepResistance={}", field)
        }

    init {
        this.sleepRequirement = sleepRequirement
        this.sleepResistance = sleepResistance
    }

    override fun toString(): String {
        return "sleepRequirement=${sleepRequirement} sleepResistance=${sleepResistance} ${super.toString()}"
    }
}