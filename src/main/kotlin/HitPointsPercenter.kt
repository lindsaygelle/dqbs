package com.github.lindsaygelle

interface HitPointsPercenter : HitPointer,
    Percenter {
    val hitPointsPercentage: Int
        get() = getPercentage(hitPoints, hitPointsMaximum)
}