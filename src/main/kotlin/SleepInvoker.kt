package com.github.lindsaygelle

interface SleepInvoker: MagicInvoker {
    var sleepRequirementMaximum: Int
    var sleepRequirementMinimum: Int
    val sleepRequirementRange: IntRange
        get() = (sleepRequirementMinimum..sleepRequirementMaximum)
}