package com.github.lindsaygelle

interface Actor : Actioner,
    AllegianceKeeper,
    BattleInvoker,
    BattleReceiver,
    HitPointsPercenter,
    Indexable,
    MagicPointPercenter,
    Nameable,
    SleepResolver,
    StopSpellLimiter,
    StopSpellResolver,
    TurnsAccumulator {
    fun act(receivers: List<BattleReceiver>)
}