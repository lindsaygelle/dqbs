package com.github.lindsaygelle

interface MagicPointPercenter : MagicPointer,
    MagicPointMaximizer,
    Percenter {
    val magicPointsPercentage: Int
        get() = getPercentage(magicPoints, magicPointsMaximum)
}