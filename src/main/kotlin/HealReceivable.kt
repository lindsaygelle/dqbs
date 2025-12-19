package com.github.lindsaygelle

class HealReceivable(
    var hitPoints: Int, var hitPointsMaximum: Int, override var timeMilliseconds: Long
) : Context