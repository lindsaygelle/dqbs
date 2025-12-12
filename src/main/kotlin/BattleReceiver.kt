package com.github.lindsaygelle

interface BattleReceiver : ActionInvoker, ActionReceiver, AgilityPointer, AllegianceKeeper, HitPointer, Indexer,
    TurnAccumulator,
    UniversalIdentifier {
    fun takeTurn(battleReceivers: List<IndexedValue<BattleReceiver>>): BattleReceiverContext
}
