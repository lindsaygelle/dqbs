package com.github.lindsaygelle

interface BattleReceiver : AttackReceiver,
    HealReceiver,
    HurtReceiver,
    SleepReceiver,
    StopSpellReceiver,
    SleepLimiter