package com.github.lindsaygelle

import java.util.*

class Armor(defense: Int, hurtReduction: Int, name: String, uuid: UUID) : DefenseEquipment(defense, name, uuid),
    HurtReducer {
    override var hurtReduction: Int = hurtReduction
        set(value) {
            field = maxOf(0, value)
            logger.trace("hurtReduction={}", field)
        }

    init {
        this.hurtReduction = hurtReduction
    }

    override fun toString(): String {
        return "{hurtReduction=${hurtReduction} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}