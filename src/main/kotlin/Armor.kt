package com.github.lindsaygelle

import java.util.*

class Armor(
    blocksSleep: Boolean,
    blockStopSpell: Boolean,
    defense: Int,
    hurtReduction: Int,
    name: String,
    uuid: UUID
) : DefenseEquipment(defense, name, uuid),
    HurtReducer,
    SleepBlocker,
    StopSpellBlocker {
    override var blocksSleep: Boolean = blocksSleep
        set(value) {
            field = value
            logger.trace("blocksSleep={}", field)
        }

    override var blockStopSpell: Boolean = blockStopSpell
        set(value) {
            field = value
            logger.trace("blockStopSpell={}", field)
        }
    override var hurtReduction: Int = hurtReduction
        set(value) {
            field = maxOf(0, value)
            logger.trace("hurtReduction={}", field)
        }

    init {
        this.blocksSleep = blocksSleep
        this.blockStopSpell = blockStopSpell
        this.hurtReduction = hurtReduction
    }

    override fun toString(): String {
        return "{blocksSleep=${blocksSleep} blockStopSpell=${blockStopSpell} hurtReduction=${hurtReduction} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}