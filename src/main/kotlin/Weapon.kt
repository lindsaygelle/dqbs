package com.github.lindsaygelle

import java.util.*

class Weapon(attack: Int, name: String, uuid: UUID) : AttackPointer,
    Equipment(name, uuid) {
    override var attack: Int = attack
        set(value) {
            field = maxOf(0, value)
            logger.trace("attack={}", field)
        }

    init {
        this.attack = attack
    }

    override fun toString(): String {
        return "{attack=${attack} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}