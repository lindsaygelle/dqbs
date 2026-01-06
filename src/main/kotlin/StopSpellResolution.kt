package com.github.lindsaygelle

import java.util.*

class StopSpellResolution(
    resolved: Boolean,
    stopSpellResolutionRandom: Int,
    timeMilliseconds: Long,
    turnsStopSpell: Int,
    uuid: UUID,
) : Resolution(
    resolved, timeMilliseconds, uuid
),
    StopSpellAccumulator {
    var stopSpellResolutionRandom: Int = stopSpellResolutionRandom
        set(value) {
            field = value
            logger.trace("stopSpellResolutionRandom={}", field)
        }
    override var turnsStopSpell: Int = turnsStopSpell
        set(value) {
            field = value
            logger.trace("turnsStopSpell={}", field)
        }

    init {
        this.stopSpellResolutionRandom = stopSpellResolutionRandom
        this.turnsStopSpell = turnsStopSpell
    }

    override fun toString(): String {
        return "stopSpellResolutionRandom=${stopSpellResolutionRandom} turnsStopSpell=${turnsStopSpell} ${super.hashCode()}"
    }
}