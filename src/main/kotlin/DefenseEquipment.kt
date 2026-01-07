package com.github.lindsaygelle

import java.util.*

open class DefenseEquipment(defense: Int, name: String, uuid: UUID) : DefensePointer,
    Equipment(name, uuid) {
    final override var defense: Int = defense
        set(value) {
            field = maxOf(0, value)
            logger.trace("defense={}", field)
        }

    init {
        this.defense = defense
    }

    override fun toString(): String {
        return "{defense=${defense} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}