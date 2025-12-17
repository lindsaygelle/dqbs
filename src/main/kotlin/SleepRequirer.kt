package com.github.lindsaygelle

interface SleepRequirer {
    var sleepRequirementMaximum: Int
    var sleepRequirementMinimum: Int
    val sleepRequirementRandom: Int
        get() = sleepRequirementRange.random()
    val sleepRequirementRange: IntRange
        get() = (sleepRequirementMinimum..sleepRequirementMaximum)
}
