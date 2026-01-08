package com.github.lindsaygelle

import java.util.*

class StopSpellReception(
    blocksStopSpell: Boolean,
    stopSpellResistance: Int,
    stopSpellResistanceMaximum: Int,
    stopSpellResistanceMinimum: Int,
    timeMilliseconds: Long,
    uuid: UUID,
) : Reception(timeMilliseconds, uuid),
    StopSpellBlocker,
    StopSpellResistanceMaximizer,
    StopSpellResistanceMinimizer {
    override var blocksStopSpell: Boolean = blocksStopSpell
        set(value) {
            field = value
            logger.trace("blocksStopSpell={}", field)
        }

    var stopSpellResistance: Int = stopSpellResistance
        set(value) {
            field = value
            logger.trace("stopSpellResistance={}", field)
        }

    override var stopSpellResistanceMaximum: Int = stopSpellResistanceMaximum
        set(value) {
            field = value
            logger.trace("stopSpellResistanceMaximum={}", field)
        }

    override var stopSpellResistanceMinimum: Int = stopSpellResistanceMinimum
        set(value) {
            field = value
            logger.trace("stopSpellResistanceMinimum={}", field)
        }

    init {
        this.blocksStopSpell = blocksStopSpell
        this.stopSpellResistance = stopSpellResistance
        this.stopSpellResistanceMaximum = stopSpellResistanceMaximum
        this.stopSpellResistanceMinimum = stopSpellResistanceMinimum
    }

    override fun toString(): String {
        return "{blocksStopSpell=${blocksStopSpell} stopSpellResistance=${stopSpellResistance} stopSpellResistanceMaximum=${stopSpellResistanceMaximum} stopSpellResistanceMinimum=${stopSpellResistanceMinimum} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}