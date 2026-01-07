package com.github.lindsaygelle

import java.util.*

class HealEffect(hitPoints: Int, timeMilliseconds: Long, uuid: UUID) : Effect(timeMilliseconds, uuid),
    HitPointer {
    override var hitPoints: Int = hitPoints
        set(value) {
            field = value
            logger.trace("hitPoints={}", field)
        }

    init {
        this.hitPoints = hitPoints
    }

    override fun toString(): String {
        return "{hitPoints=${hitPoints} ${super.toString()}}"
    }
}