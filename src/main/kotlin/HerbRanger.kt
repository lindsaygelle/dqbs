package com.github.lindsaygelle

interface HerbRanger {
    val herbRange: IntRange
        get() = (herbRangeMinimum..herbRangeMaximum)
    var herbRangeMaximum: Int
    var herbRangeMinimum: Int
}
