package com.github.lindsaygelle

interface HerbRanger {
    val herbRandom: Int
        get() = herbRange.random()
    val herbRange: IntRange
        get() = (herbRangeMinimum..herbRangeMaximum)
    var herbRangeMaximum: Int
    var herbRangeMinimum: Int
}
