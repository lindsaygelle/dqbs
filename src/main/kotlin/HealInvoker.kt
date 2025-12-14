package com.github.lindsaygelle

interface HealInvoker: MagicInvoker {
    val healRange: IntRange
        get() = (healRangeMinimum..healRangeMaximum)
    var healRangeMaximum: Int
    var healRangeMinimum: Int
    val healRangeValue: Int
    var healScale: Int
    var healShift: Int
}