package com.github.lindsaygelle

class SleepReceivable : Receivable<SleepReceiver>() {
    override fun receive(receiver: SleepReceiver): Reception {
        return SleepReception(
            receiver.sleepResistanceRange.random(),
            receiver.sleepResistanceMaximum,
            receiver.sleepResistanceMinimum
        )
    }
}
