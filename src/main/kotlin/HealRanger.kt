package com.github.lindsaygelle

interface HealRanger {
    val healRandom: Int
        get() = healRange.random()
    val healRange: IntRange
        get() = (healRangeMinimum..healRangeMaximum)
    var healRangeMaximum: Int
    var healRangeMinimum: Int
}
