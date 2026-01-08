package com.github.lindsaygelle

interface HealRanger : HealRangeMaximizer,
    HealRangeMinimizer {
    val healRange: IntRange
        get() = (healRangeMinimum..healRangeMaximum)
}