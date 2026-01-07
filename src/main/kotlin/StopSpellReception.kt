package com.github.lindsaygelle

import java.util.*

class StopSpellReception(
    stopSpellResistance: Int,
    stopSpellResistanceMaximum: Int,
    stopSpellResistanceMinimum: Int,
    timeMilliseconds: Long,
    uuid: UUID,
) : Reception(timeMilliseconds, uuid) {
    var stopSpellResistance: Int = stopSpellResistance
        set(value) {
            field = value
            logger.trace("stopSpellResistance={}", field)
        }

    var stopSpellResistanceMaximum: Int = stopSpellResistanceMaximum
        set(value) {
            field = value
            logger.trace("stopSpellResistanceMaximum={}", field)
        }

    var stopSpellResistanceMinimum: Int = stopSpellResistanceMinimum
        set(value) {
            field = value
            logger.trace("stopSpellResistanceMinimum={}", field)
        }

    init {
        this.stopSpellResistance = stopSpellResistance
        this.stopSpellResistanceMaximum = stopSpellResistanceMaximum
        this.stopSpellResistanceMinimum = stopSpellResistanceMinimum
    }

    override fun toString(): String {
        return "{stopSpellResistance=${stopSpellResistance} stopSpellResistanceMaximum=${stopSpellResistanceMaximum} stopSpellResistanceMinimum=${stopSpellResistanceMinimum} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}