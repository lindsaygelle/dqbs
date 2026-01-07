package com.github.lindsaygelle

import java.util.*

class SleepReceivable : Receivable<SleepReceiver, SleepReception>() {
    override fun receive(receiver: SleepReceiver): SleepReception {
        return SleepReception(
            receiver.sleepResistance,
            receiver.sleepResistanceMaximum,
            receiver.sleepResistanceMinimum,
            System.currentTimeMillis(),
            UUID.randomUUID()
        )
    }
}