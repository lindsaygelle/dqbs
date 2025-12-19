package com.github.lindsaygelle

interface MagicPointPercenter : MagicPointer,
    MagicPointMaximizer {
    val magicPointsPercentage: Int
        get() = ((magicPoints.toDouble() / magicPointsMaximum.toDouble()) * 100).toInt()
}