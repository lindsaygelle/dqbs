package com.github.lindsaygelle

interface HerbRanger {
    val herbRange: IntRange
        get() = (herbRangeMinimum..herbRangeMaximum)
    val herbRangeRandom: Int
        get() = herbRange.random()
    var herbRangeMaximum: Int
    var herbRangeMinimum: Int
}
