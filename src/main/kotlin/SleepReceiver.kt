package com.github.lindsaygelle

interface SleepReceiver : AbilityReceiver,
    SleepResister {
    var statusSleep: Boolean
}