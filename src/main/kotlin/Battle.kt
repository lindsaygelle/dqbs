package com.github.lindsaygelle

import java.util.UUID

class Battle(battleParticipators: Collection<BattleParticipator>) : Identifier,
    TurnAccumulator {
    var battleParticipators: Collection<BattleParticipator> = battleParticipators
    override var turns: Int = 0
    override var uuid: UUID = UUID.randomUUID()
    init {
        this.battleParticipators = battleParticipators
    }
    private fun filterBattleParticipator(battleParticipator: BattleParticipator, battleParticipatorIndex: Int) {
        battleParticipator.hitPoints > 0
    }
    private fun filterBattleParticipators(battleParticipators: Collection<BattleParticipator>): Collection<BattleParticipator> {
        return battleParticipators.withIndex().filter { indexedValue -> indexedValue.index }
    }

    fun tick() {
        turns++
    }
}