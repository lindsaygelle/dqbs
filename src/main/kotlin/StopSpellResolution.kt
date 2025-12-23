package com.github.lindsaygelle

class StopSpellResolution(
    resolved: Boolean,
    stopSpellResolutionRandom: Int,
    timeMilliseconds: Long,
    turnsStopSpell: Int,
) : Resolution(
    resolved, timeMilliseconds
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
}
