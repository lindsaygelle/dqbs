package com.github.lindsaygelle

import java.util.*

class SleepReception(
    blocksSleep: Boolean,
    sleepResistance: Int,
    sleepResistanceMaximum: Int,
    sleepResistanceMinimum: Int,
    timeMilliseconds: Long,
    uuid: UUID,
) : Reception(timeMilliseconds, uuid),
    SleepBlocker,
    SleepResistanceMaximizer,
    SleepResistanceMinimizer {
    override var blocksSleep: Boolean = blocksSleep
        set(value) {
            field = value
            logger.trace("blocksSleep={}", field)
        }

    var sleepResistance: Int = sleepResistance
        set(value) {
            field = value
            logger.trace("sleepResistance={}", field)
        }

    override var sleepResistanceMaximum: Int = sleepResistanceMaximum
        set(value) {
            field = value
            logger.trace("sleepResistanceMaximum={}", field)
        }

    override var sleepResistanceMinimum: Int = sleepResistanceMinimum
        set(value) {
            field = value
            logger.trace("sleepResistanceMinimum={}", field)
        }

    init {
        this.blocksSleep = blocksSleep
        this.sleepResistance = sleepResistance
        this.sleepResistanceMaximum = sleepResistanceMaximum
        this.sleepResistanceMinimum = sleepResistanceMinimum
    }

    override fun toString(): String {
        return "{blocksSleep=${blocksSleep} sleepResistance=${sleepResistance} sleepResistanceMaximum=${sleepResistanceMaximum} sleepResistanceMinimum=${sleepResistanceMinimum} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}