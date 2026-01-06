package com.github.lindsaygelle

interface HurtRanger {
    val hurtRange: IntRange
        get() = (hurtRangeMinimum..hurtRangeMaximum)
    val hurtRangeRandom: Int
        get() = hurtRange.random()
    var hurtRangeMaximum: Int
    var hurtRangeMinimum: Int
}
