package com.github.lindsaygelle

interface HurtInvoker: MagicInvoker {
    val hurtRange: IntRange
        get() = (hurtRangeMinimum..hurtRangeMaximum)
    var hurtRangeMaximum: Int
    var hurtRangeMinimum: Int
    var hurtScale: Int
    var hurtShift: Int
}