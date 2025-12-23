package com.github.lindsaygelle

interface StopSpellLimiter : StopSpellAccumulator {
    var turnsStopSpellMaximum: Int
    var turnsStopSpellMinimum: Int
}