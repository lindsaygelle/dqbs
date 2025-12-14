package com.github.lindsaygelle

interface Battler : Actioner,
    BattleInvoker,
    BattleReceiver,
    HitPointsPercenter,
    Namer,
    TurnsAccumulator
