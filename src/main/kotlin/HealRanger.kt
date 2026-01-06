package com.github.lindsaygelle

interface HealRanger {
    val healRange: IntRange
        get() = (healRangeMinimum..healRangeMaximum)
    val healRangeRandom: Int
        get() = healRange.random()
    var healRangeMaximum: Int
    var healRangeMinimum: Int
}
