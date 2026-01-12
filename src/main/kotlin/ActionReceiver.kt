package com.github.lindsaygelle

interface ActionReceiver: AllegianceKeeper,
    BattleInvoker,
    BattleReceiver,
    HitPointsPercenter,
    MagicPointPercenter,
    Nameable,
    SleepResolver,
    StopSpellLimiter,
    StopSpellResolver,
    TurnsAccumulator