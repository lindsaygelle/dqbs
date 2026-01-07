package com.github.lindsaygelle

import java.util.*

class Heal(
    limit: Int, magicPoints: Int,
) : MagicAbility<HealInvoker, HealReceiver, HealInvocation, HealReception, HealCheck, HealEffect>(limit, magicPoints) {
    override fun getCheckable(): Checkable<HealInvocation, HealReception, HealCheck> {
        return HealCheckable(magicPoints)
    }

    override fun getEffect(
        check: HealCheck,
        invocation: HealInvocation,
        invoker: HealInvoker,
        receiver: HealReceiver,
        reception: HealReception,
    ): HealEffect {
        if (check.result) {
            receiver.hitPoints += invocation.heal
        }
        return HealEffect(receiver.hitPoints, reception.hitPoints, System.currentTimeMillis(), UUID.randomUUID())
    }

    override fun getInvocable(): Invocable<HealInvoker, HealInvocation> {
        return HealInvocable(magicPoints)
    }

    override fun getReceivable(): Receivable<HealReceiver, HealReception> {
        return HealReceivable()
    }
}