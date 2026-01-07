package com.github.lindsaygelle

import java.util.*

class StopSpellEffect(statusStopSpell: Boolean, timeMilliseconds: Long, uuid: UUID) : Effect(timeMilliseconds, uuid),
    StopSpellToggler {
    override var statusStopSpell: Boolean = statusStopSpell
        set(value) {
            field = value
            logger.trace("statusStopSpell={}", field)
        }

    init {
        this.statusStopSpell = statusStopSpell
    }

    override fun toString(): String {
        return "{statusStopSpell=${statusStopSpell} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}