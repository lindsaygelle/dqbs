package com.github.lindsaygelle

interface SleepRequirer {
    var sleepRequirementMaximum: Int
    var sleepRequirementMinimum: Int
    val sleepRequirementRange: IntRange
        get() = (sleepRequirementMinimum..sleepRequirementMaximum)
}