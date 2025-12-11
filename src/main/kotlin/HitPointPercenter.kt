package com.github.lindsaygelle

interface HitPointPercenter : HitPointer,
    HitPointMaximizer,
    Percenter {
    val hitPointsPercentage: Int
        get() = getPercentage(hitPoints, hitPointsMaximum)
}