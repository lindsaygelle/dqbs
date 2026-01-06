package com.github.lindsaygelle

class SleepReceivable : Receivable<SleepReceiver, SleepReception>() {
    override fun receive(receiver: SleepReceiver): SleepReception {
        return SleepReception(
            receiver.sleepResistance, receiver.sleepResistanceMaximum, receiver.sleepResistanceMinimum
        )
    }
}