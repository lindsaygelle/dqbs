package com.github.lindsaygelle

interface Battler : Actioner,
    AllegianceKeeper,
    BattleInvoker,
    BattleReceiver,
    HitPointsPercenter,
    Indexable,
    ItemInvoker,
    MagicPointPercenter,
    Nameable {
    fun turn(battleReceivers: List<BattleReceiver>): BattlerContext
}
