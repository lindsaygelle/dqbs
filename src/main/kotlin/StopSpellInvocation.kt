package com.github.lindsaygelle

import java.util.*

class StopSpellInvocation(
    magicPoints: Int,
    stopSpellRequirement: Int,
    stopSpellRequirementMaximum: Int,
    stopSpellRequirementMinimum: Int,
    timeMilliseconds: Long,
    uuid: UUID,
) : MagicInvocation(magicPoints, timeMilliseconds, uuid),
    StopSpellRequirementMaximizer,
    StopSpellRequirementMinimizer {
    var stopSpellRequirement: Int = stopSpellRequirement
        set(value) {
            field = value
            logger.trace("stopSpellRequirement={}", field)
        }

    override var stopSpellRequirementMaximum: Int = stopSpellRequirementMaximum
        set(value) {
            field = value
            logger.trace("stopSpellRequirementMaximum={}", field)
        }

    override var stopSpellRequirementMinimum: Int = stopSpellRequirementMinimum
        set(value) {
            field = value
            logger.trace("stopSpellRequirementMinimum={}", field)
        }

    init {
        this.stopSpellRequirement = stopSpellRequirement
        this.stopSpellRequirementMaximum = stopSpellRequirementMaximum
        this.stopSpellRequirementMinimum = stopSpellRequirementMinimum
    }

    override fun toString(): String {
        return "{stopSpellRequirement=${stopSpellRequirement} stopSpellRequirementMaximum=${stopSpellRequirementMaximum} stopSpellRequirementMinimum=${stopSpellRequirementMinimum} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}