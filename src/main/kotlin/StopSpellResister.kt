package com.github.lindsaygelle

interface StopSpellResister {
    var stopSpellResistanceMaximum: Int
    var stopSpellResistanceMinimum: Int
    val stopSpellResistanceRange: IntRange
        get() = (stopSpellResistanceMinimum..stopSpellResistanceMaximum)
}