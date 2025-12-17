package com.github.lindsaygelle

interface HurtRanger {
    val hurtRandom: Int
        get() = hurtRange.random()
    val hurtRange: IntRange
        get() = (hurtRangeMinimum..hurtRangeMaximum)
    var hurtRangeMaximum: Int
    var hurtRangeMinimum: Int
}
