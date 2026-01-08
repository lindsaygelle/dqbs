package com.github.lindsaygelle

import java.util.*

class HurtReception(
    hitPoints: Int,
    hurtResistance: Int,
    hurtResistanceMaximum: Int,
    hurtResistanceMinimum: Int,
    timeMilliseconds: Long,
    uuid: UUID
) : Reception(timeMilliseconds, uuid),
    HitPointer,
    HurtResistanceMaximizer,
    HurtResistanceMinimizer {
    override var hitPoints: Int = hitPoints
        set(value) {
            field = value
            logger.trace("hitPoints={}", field)
        }

    var hurtResistance: Int = hurtResistance
        set(value) {
            field = value
            logger.trace("hurtResistance={}", field)
        }

    override var hurtResistanceMaximum: Int = hurtResistanceMaximum
        set(value) {
            field = value
            logger.trace("hurtResistanceMaximum={}", field)
        }

    override var hurtResistanceMinimum: Int = hurtResistanceMinimum
        set(value) {
            field = value
            logger.trace("hurtResistanceMinimum={}", field)
        }

    init {
        this.hitPoints = hitPoints
        this.hurtResistance = hurtResistance
        this.hurtResistanceMaximum = hurtResistanceMaximum
        this.hurtResistanceMinimum = hurtResistanceMinimum
    }

    override fun toString(): String {
        return "{hitPoints=${hitPoints} hurtResistance=${hurtResistance} hurtResistanceMaximum=${hurtResistanceMaximum} hurtResistanceMinimum=${hurtResistanceMinimum} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}