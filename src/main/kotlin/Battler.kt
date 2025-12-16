package com.github.lindsaygelle

interface Battler : Actioner,
    AllegianceKeeper,
    BattleInvoker,
    BattleReceiver,
    HitPointsPercenter,
    MagicPointPercenter,
    Namer,
    TurnsAccumulator
