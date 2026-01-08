package com.github.lindsaygelle

import java.util.*

class HurtInvocation(
    hurtRequirement: Int,
    hurtRequirementMaximum: Int,
    hurtRequirementMinimum: Int,
    magicPoints: Int,
    timeMilliseconds: Long,
    uuid: UUID
) : MagicInvocation(
    magicPoints, timeMilliseconds, uuid
),  HurtRequirementMaximizer,
    HurtRequirementMinimizer {
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
        this.hurtRequirement = hurtRequirement
        this.hurtRequirementMaximum = hurtRequirementMaximum
        this.hurtRequirementMinimum = hurtRequirementMinimum
    }

    override fun toString(): String {
        return "hurtRequirement=${hurtRequirement} hurtRequirementMaximum=${hurtRequirementMaximum} hurtRequirementMinimum=${hurtRequirementMinimum} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}