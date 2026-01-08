package com.github.lindsaygelle

import java.util.*

class Hurt(limit: Int, magicPoints: Int) : HurtAbility<HurtInvoker>(limit, magicPoints) {
    override fun getEffect(
        check: HurtCheck,
        invocation: HurtInvocation,
        invoker: HurtInvoker,
        receiver: HurtReceiver,
        reception: HurtReception
    ): HurtEffect {
        if (check.result) {
            receiver.hitPoints -= (invocation.hurt + reception.hurtReduction)
        }
        return HurtEffect(receiver.hitPoints, reception.hitPoints, System.currentTimeMillis(), UUID.randomUUID())
    }

    override fun getInvocable(): Invocable<HurtInvoker, HurtInvocation> {
        return HurtInvocable()
    }
}