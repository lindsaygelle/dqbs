package com.github.lindsaygelle

interface HurtResister {
    var hurtResistanceMaximum: Int
    var hurtResistanceMinimum: Int
    val hurtResistanceRandom: Int
        get() = hurtResistanceRange.random()
    val hurtResistanceRange: IntRange
        get() = (hurtResistanceMinimum..hurtResistanceMaximum)
}
