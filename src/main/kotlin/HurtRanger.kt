package com.github.lindsaygelle

interface HurtRanger {
    val hurtRange: IntRange
        get() = (hurtRangeMinimum..hurtRangeMaximum)
    var hurtRangeMaximum: Int
    var hurtRangeMinimum: Int
}
