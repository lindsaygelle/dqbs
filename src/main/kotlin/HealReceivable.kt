package com.github.lindsaygelle

import java.util.*

class HealReceivable : Receivable<HealReceiver, HealReception>() {
    override fun receive(receiver: HealReceiver): HealReception {
        return HealReception(
            receiver.hitPoints,
            System.currentTimeMillis(),
            UUID.randomUUID(),
        )
    }
}