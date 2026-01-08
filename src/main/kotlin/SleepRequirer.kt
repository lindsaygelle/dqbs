package com.github.lindsaygelle

interface SleepRequirer : SleepRequirementMaximizer,
    SleepRequirementMinimizer {
    val sleepRequirementRange: IntRange
        get() = (sleepRequirementMinimum..sleepRequirementMaximum)
    val sleepRequirement: Int
        get() = sleepRequirementRange.random()
}