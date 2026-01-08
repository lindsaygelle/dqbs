package com.github.lindsaygelle

interface StopSpellRequirer : StopSpellRequirementMaximizer,
    StopSpellRequirementMinimizer {
    val stopSpellRequirement: Int
        get() = stopSpellRequirementRange.random()
    val stopSpellRequirementRange: IntRange
        get() = (stopSpellRequirementMinimum..stopSpellRequirementMaximum)
}