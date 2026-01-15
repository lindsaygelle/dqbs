package com.github.lindsaygelle.dqbs

interface SleepReceiver : AbilityReceiver {
    var sleepResistanceMaximum: Int
    var sleepResistanceMinimum: Int
    var statusSleep: Boolean
}