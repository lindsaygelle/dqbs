package com.github.lindsaygelle

interface StopSpellResister : StopSpellResistanceMaximizer,
    StopSpellResistanceMinimizer {
    val stopSpellResistance: Int
        get() = stopSpellResistanceRange.random()
    val stopSpellResistanceRange: IntRange
        get() = (stopSpellResistanceMinimum..stopSpellResistanceMaximum)
}