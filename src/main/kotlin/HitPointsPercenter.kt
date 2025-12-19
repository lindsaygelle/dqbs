package com.github.lindsaygelle

interface HitPointsPercenter : HitPointer,
    HitPointerMaximizer {
    val hitPointsPercentage: Int
        get() = ((hitPoints.toDouble() / hitPointsMaximum.toDouble()) * 100).toInt()
}