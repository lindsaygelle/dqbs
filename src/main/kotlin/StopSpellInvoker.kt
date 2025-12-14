package com.github.lindsaygelle

interface StopSpellInvoker: MagicInvoker {
    var stopSpellRequirementMaximum: Int
    var stopSpellRequirementMinimum: Int
    val stopSpellRequirementRange: IntRange
        get() = (stopSpellRequirementMinimum..stopSpellRequirementMaximum)
}