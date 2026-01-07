package com.github.lindsaygelle

import java.util.*

class HealCheck(
    heal: Int,
    magicPoints: Int,
    magicPointsRequirement: Int,
    timeMilliseconds: Long,
    uuid: UUID,
) : MagicCheck(magicPoints, magicPointsRequirement, timeMilliseconds, uuid) {
    var heal: Int = heal
        set(value) {
            field = value
            logger.trace("heal={}", field)
        }

    override val result: Boolean
        get() = super.result && heal > 0

    init {
        this.heal = heal
    }

    override fun toString(): String {
        return "{heal=${heal} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}