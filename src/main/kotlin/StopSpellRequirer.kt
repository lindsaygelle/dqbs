package com.github.lindsaygelle

interface StopSpellRequirer {
    var stopSpellRequirementMaximum: Int
    var stopSpellRequirementMinimum: Int
    val stopSpellRequirementRange: IntRange
        get() = (stopSpellRequirementMinimum..stopSpellRequirementMaximum)
}
