package com.github.lindsaygelle

interface HurtResister {
    var hurtResistanceMaximum: Int
    var hurtResistanceMinimum: Int
    val hurtResistanceRange: IntRange
        get() = (hurtResistanceMinimum..hurtResistanceMaximum)
}
