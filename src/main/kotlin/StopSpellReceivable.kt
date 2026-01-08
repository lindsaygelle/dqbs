package com.github.lindsaygelle

import java.util.*

class StopSpellReceivable : Receivable<StopSpellReceiver, StopSpellReception>() {
    override fun receive(receiver: StopSpellReceiver): StopSpellReception {
        return StopSpellReception(
            receiver.armor?.blocksStopSpell ?: false,
            receiver.stopSpellResistance,
            receiver.stopSpellResistanceMaximum,
            receiver.stopSpellResistanceMinimum,
            System.currentTimeMillis(),
            UUID.randomUUID()
        )
    }
}