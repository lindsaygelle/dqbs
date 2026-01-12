package com.github.lindsaygelle

interface ActionReceiver : AllegianceKeeper,
    AttributeReceiver,
    BattleInvoker,
    BattleReceiver,
    HitPointsPercenter,
    MagicPointPercenter,
    Nameable,
    SleepResolver,
    StopSpellLimiter,
    StopSpellResolver,
    TurnsAccumulator