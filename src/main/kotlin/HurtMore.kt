package com.github.lindsaygelle

import java.util.*

class HurtMore(limit: Int, magicPoints: Int) : HurtAbility<HurtMoreInvoker>(limit, magicPoints) {
    override fun getEffect(
        check: HurtCheck,
        invocation: HurtInvocation,
        invoker: HurtMoreInvoker,
        receiver: HurtReceiver,
        reception: HurtReception,
    ): HurtEffect {
        if (check.result) {
            receiver.hitPoints -= (invocation.hurt + reception.hurtReduction)
        }
        return HurtEffect(receiver.hitPoints, reception.hitPoints, System.currentTimeMillis(), UUID.randomUUID())
    }

    override fun getInvocable(): Invocable<HurtMoreInvoker, HurtInvocation> {
        return HurtMoreInvocable()
    }
}