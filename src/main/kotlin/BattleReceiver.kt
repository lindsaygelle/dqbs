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
/*
interface BattleReceiver : ActionInvoker, ActionReceiver, AgilityPointer, AllegianceKeeper, HitPointer, Indexer,
    TurnAccumulator,
    UniversalIdentifier {
    fun takeTurn(battleReceivers: List<IndexedValue<BattleReceiver>>): BattleReceiverContext
}
*/
