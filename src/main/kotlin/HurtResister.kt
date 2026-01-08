package com.github.lindsaygelle

interface HurtResister : HurtResistanceMaximizer,
    HurtResistanceMinimizer {
    val hurtResistance: Int
        get() = hurtResistanceRange.random()
    val hurtResistanceRange: IntRange
        get() = (hurtResistanceMinimum..hurtResistanceMaximum)
}