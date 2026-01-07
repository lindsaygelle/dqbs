package com.github.lindsaygelle

import java.util.*

class StopSpellCheck(
    magicPoints: Int,
    magicPointsRequirement: Int,
    stopSpellRequirement: Int,
    stopSpellResistance: Int,
    timeMilliseconds: Long,
    uuid: UUID,
) : MagicCheck(
    magicPoints, magicPointsRequirement, timeMilliseconds, uuid
) {
    override val result: Boolean
        get() = super.result && (stopSpellRequirement >= stopSpellResistance)

    var stopSpellRequirement: Int = stopSpellRequirement
        set(value) {
            field = value
            logger.trace("stopSpellRequirement={}", field)
        }

    var stopSpellResistance: Int = stopSpellResistance
        set(value) {
            field = value
            logger.trace("stopSpellResistance={}", field)
        }

    init {
        this.stopSpellRequirement = stopSpellRequirement
        this.stopSpellResistance = stopSpellResistance
    }

    override fun toString(): String {
        return "{stopSpellRequirement=${stopSpellRequirement} stopSpellResistance=${stopSpellResistance} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}