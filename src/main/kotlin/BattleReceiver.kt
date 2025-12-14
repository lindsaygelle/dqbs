package com.github.lindsaygelle

interface BattleReceiver : AttackReceiver,
    HealReceiver,
    HurtReceiver,
    SleepLimiter,
    SleepReceiver,
    SleepResolver,
    StopSpellReceiver,
    StopSpellLimiter,
    StopSpellResolver,
    TurnsAccumulator