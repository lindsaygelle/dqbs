package com.github.lindsaygelle

import java.util.*

class HurtReceivable : Receivable<HurtReceiver, HurtReception>() {
    override fun receive(receiver: HurtReceiver): HurtReception {
        return HurtReception(
            receiver.hitPoints,
            receiver.hurtResistance,
            receiver.hurtResistanceMaximum,
            receiver.hurtResistanceMinimum,
            System.currentTimeMillis(),
            UUID.randomUUID(),
        )
    }
}