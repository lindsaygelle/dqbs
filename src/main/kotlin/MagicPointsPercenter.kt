package com.github.lindsaygelle

interface MagicPointsPercenter : MagicPointer,
    Percenter {
    val magicPointsPercentage: Int
        get() = getPercentage(magicPoints, magicPointsMaximum)
}