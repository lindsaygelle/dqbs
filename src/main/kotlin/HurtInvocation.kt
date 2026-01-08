package com.github.lindsaygelle

import java.util.*

class HurtInvocation(
    hurt: Int,
    hurtOffset: Int,
    hurtRandom: Int,
    hurtRequirement: Int,
    hurtRequirementMaximum: Int,
    hurtRequirementMinimum: Int,
    magicPoints: Int,
    timeMilliseconds: Long,
    uuid: UUID,
) : MagicInvocation(
    magicPoints, timeMilliseconds, uuid
),
    HurtRequirementMaximizer,
    HurtRequirementMinimizer {
    var hurt: Int = hurt
        set(value) {
            field = value
            logger.trace("hurt={}", field)
        }

    var hurtOffset: Int = hurtOffset
        set(value) {
            field = value
            logger.trace("hurtOffset={}", field)
        }

    var hurtRandom: Int = hurtRandom
        set(value) {
            field = value
            logger.trace("hurtRandom={}", field)
        }

    var hurtRequirement: Int = hurtRequirement
        set(value) {
            field = value
            logger.trace("hurtRequirement={}", field)
        }

    override var hurtRequirementMaximum: Int = hurtRequirementMaximum
        set(value) {
            field = value
            logger.trace("hurtRequirementMaximum={}", field)
        }

    override var hurtRequirementMinimum: Int = hurtRequirementMinimum
        set(value) {
            field = value
            logger.trace("hurtRequirementMinimum={}", field)
        }

    init {
        this.hurt = hurt
        this.hurtOffset = hurtOffset
        this.hurtRandom = hurtRandom
        this.hurtRequirement = hurtRequirement
        this.hurtRequirementMaximum = hurtRequirementMaximum
        this.hurtRequirementMinimum = hurtRequirementMinimum
    }

    override fun toString(): String {
        return "hurt=${hurt} hurtOffset=${hurtOffset} hurtRandom=${hurtRandom} hurtRequirement=${hurtRequirement} hurtRequirementMaximum=${hurtRequirementMaximum} hurtRequirementMinimum=${hurtRequirementMinimum} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}