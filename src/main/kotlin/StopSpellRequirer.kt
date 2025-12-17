package com.github.lindsaygelle

interface StopSpellRequirer {
    val stopSpellRequirementRandom: Int
        get() = stopSpellRequirementRange.random()
    var stopSpellRequirementMaximum: Int
    var stopSpellRequirementMinimum: Int
    val stopSpellRequirementRange: IntRange
        get() = (stopSpellRequirementMinimum..stopSpellRequirementMaximum)
}
