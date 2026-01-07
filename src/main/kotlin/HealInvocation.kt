package com.github.lindsaygelle

import java.util.*

class HealInvocation(
    heal: Int,
    healOffset: Int,
    healRandom: Int,
    healRangeMaximum: Int,
    healRangeMinimum: Int,
    magicPoints: Int,
    timeMilliseconds: Long,
    uuid: UUID,
) : MagicInvocation(
    magicPoints, timeMilliseconds, uuid
) {
    var heal: Int = heal
        set(value) {
            field = value
            logger.trace("heal={}", field)
        }

    var healOffset: Int = healOffset
        set(value) {
            field = value
            logger.trace("healOffset={}", field)
        }

    var healRandom: Int = healRandom
        set(value) {
            field = value
            logger.trace("healRandom={}", field)
        }

    var healRangeMaximum: Int = healRangeMaximum
        set(value) {
            field = value
            logger.trace("healRangeMaximum={}", field)
        }

    var healRangeMinimum: Int = healRangeMinimum
        set(value) {
            field = value
            logger.trace("healRangeMinimum={}", field)
        }

    init {
        this.heal = heal
        this.healRandom = healRandom
        this.healRangeMaximum = healRangeMaximum
        this.healRangeMinimum = healRangeMinimum
    }

    override fun toString(): String {
        return "{heal=${heal} healOffset=${healOffset} healRandom=${healRandom} healRangeMaximum=${healRangeMaximum} healRangeMinimum=${healRangeMinimum} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}