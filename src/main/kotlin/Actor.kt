package com.github.lindsaygelle.dqbs

interface Actor : HealInvoker,
    HealMoreInvoker,
    HealReceiver,
    SleepInvoker,
    SleepReceiver,
    StopSpellInvoker,
    StopSpellReceiver {
    val agility: Int
    var allegiance: Int
    val strength: Int
}