package com.github.lindsaygelle

interface HurtRequirer : HurtRequirementMaximizer,
    HurtRequirementMinimizer {
    val hurtRequirement: Int
        get() = hurtRequirementRange.random()
    val hurtRequirementRange: IntRange
        get() = hurtRequirementMinimum..hurtRequirementMaximum
}