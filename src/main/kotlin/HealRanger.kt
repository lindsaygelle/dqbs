package com.github.lindsaygelle

interface HealRanger {
    val healRange: IntRange
        get() = (healRangeMinimum..healRangeMaximum)
    var healRangeMaximum: Int
    var healRangeMinimum: Int
}