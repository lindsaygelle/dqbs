package com.github.lindsaygelle

import java.util.*

class HurtCheck(
    hurtRequirement: Int,
    hurtResistance: Int,
    magicPoints: Int,
    magicPointsRequirement: Int,
    timeMilliseconds: Long,
    uuid: UUID
) : MagicCheck(
    magicPoints,
    magicPointsRequirement,
    timeMilliseconds,
    uuid
) {
    var hurtRequirement: Int = hurtRequirement
        set(value) {
            field = value
            logger.trace("hurtRequirement={}", field)
        }

    var hurtResistance: Int = hurtResistance
        set(value) {
            field = value
            logger.trace("hurtResistance={}", field)
        }

    override val result: Boolean
        get() = super.result && (hurtRequirement >= hurtResistance)

    init {
        this.hurtRequirement = hurtRequirement
        this.hurtResistance = hurtResistance
    }

    override fun toString(): String {
        return "{hurtRequirement=${hurtRequirement} hurtResistance=${hurtResistance} ${this.javaClass.superclass.simpleName}={${super.toString()}}"
    }
}