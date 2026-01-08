package com.github.lindsaygelle

import java.util.*

class Armor(
    blocksSleep: Boolean,
    blocksStopSpell: Boolean,
    defense: Int,
    hurtReduction: Int,
    name: String,
    uuid: UUID,
) : DefenseEquipment(defense, name, uuid),
    HurtReducer,
    SleepBlocker,
    StopSpellBlocker {
    override var blocksSleep: Boolean = blocksSleep
        set(value) {
            field = value
            logger.trace("blocksSleep={}", field)
        }

    override var blocksStopSpell: Boolean = blocksStopSpell
        set(value) {
            field = value
            logger.trace("blocksStopSpell={}", field)
        }

    override var hurtReduction: Int = hurtReduction
        set(value) {
            field = maxOf(0, value)
            logger.trace("hurtReduction={}", field)
        }

    init {
        this.blocksSleep = blocksSleep
        this.blocksStopSpell = blocksStopSpell
        this.hurtReduction = hurtReduction
    }

    override fun toString(): String {
        return "{blocksSleep=${blocksSleep} blocksStopSpell=${blocksStopSpell} hurtReduction=${hurtReduction} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}