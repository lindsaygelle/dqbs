package com.github.lindsaygelle

interface StopSpellResolver : Resolver,
    StopSpellLimiter,
    StopSpellToggler {
    var stopSpellResolutionMaximum: Int
    var stopSpellResolutionMinimum: Int
    val stopSpellResolutionRange: IntRange
        get() = (stopSpellResolutionMinimum..stopSpellResolutionMaximum)
    val stopSpellResolutionRandom: Int
        get() = stopSpellResolutionRange.random()
}