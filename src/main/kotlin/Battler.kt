package com.github.lindsaygelle

interface Battler : Actioner,
    AllegianceKeeper,
    BattleInvoker,
    BattleReceiver,
    HitPointsPercenter,
    Indexable,
    MagicPointPercenter,
    Nameable {
    fun turn(battlers: List<Battler>): BattlerContext
}
