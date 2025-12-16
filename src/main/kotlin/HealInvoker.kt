package com.github.lindsaygelle

interface HealInvoker : HealRanger,
    MagicInvoker {
    val healRangeRandom: Int
        get() = healRange.random()
    var healScale: Int
    var healShift: Int
}