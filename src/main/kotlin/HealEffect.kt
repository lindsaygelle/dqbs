package com.github.lindsaygelle

import java.util.*

class HealEffect(hitPoints: Int, hitPointsPrevious: Int, timeMilliseconds: Long, uuid: UUID) : Effect(
    timeMilliseconds, uuid
),
    HitPointer {
    override var hitPoints: Int = hitPoints
        set(value) {
            field = value
            logger.trace("hitPoints={}", field)
        }
    var hitPointsPrevious: Int = hitPointsPrevious
        set(value) {
            field = value
            logger.trace("hitPointsPrevious={}", field)
        }

    init {
        this.hitPoints = hitPoints
        this.hitPointsPrevious = hitPointsPrevious
    }

    override fun toString(): String {
        return "{hitPoints=${hitPoints} hitPointsPrevious=${hitPointsPrevious} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}