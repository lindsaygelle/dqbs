package com.github.lindsaygelle

interface SleepLimiter : SleepAccumulator {
    var turnsSleepMaximum: Int
    var turnsSleepMinimum: Int
}