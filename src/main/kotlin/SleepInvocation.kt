package com.github.lindsaygelle

import java.util.*

class SleepInvocation(
    magicPoints: Int,
    sleepRequirement: Int,
    sleepRequirementMaximum: Int,
    sleepRequirementMinimum: Int,
    timeMilliseconds: Long,
    uuid: UUID,
) : MagicInvocation(magicPoints, timeMilliseconds, uuid),
    SleepRequirementMaximizer,
    SleepRequirementMinimizer {
    var sleepRequirement: Int = sleepRequirement
        set(value) {
            field = value
            logger.trace("sleepRequirement={}", field)
        }

    override var sleepRequirementMaximum: Int = sleepRequirementMaximum
        set(value) {
            field = value
            logger.trace("sleepRequirementMaximum={}", field)
        }

    override var sleepRequirementMinimum: Int = sleepRequirementMinimum
        set(value) {
            field = value
            logger.trace("sleepRequirementMinimum={}", field)
        }

    init {
        this.sleepRequirement = sleepRequirement
        this.sleepRequirementMaximum = sleepRequirementMaximum
        this.sleepRequirementMinimum = sleepRequirementMinimum
    }

    override fun toString(): String {
        return "{sleepRequirement=${sleepRequirement} sleepRequirementMaximum=${sleepRequirementMaximum} sleepRequirementMinimum=${sleepRequirementMinimum} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}