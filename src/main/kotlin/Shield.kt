package com.github.lindsaygelle

import java.util.*

class Shield(defense: Int, name: String, uuid: UUID) : DefensePointer,
    Equipment(name, uuid) {
    override var defense: Int = defense
        set(value) {
            field = maxOf(0, value)
            logger.trace("defense={}", field)
        }

    init {
        this.defense = defense
    }
}