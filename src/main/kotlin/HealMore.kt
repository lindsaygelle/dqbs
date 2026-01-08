package com.github.lindsaygelle

import java.util.*

class HealMore(
    limit: Int,
    magicPoints: Int,
) : HealAbility<HealMoreInvoker>(
    limit, magicPoints
) {
    override fun getEffect(
        check: HealCheck,
        invocation: HealInvocation,
        invoker: HealMoreInvoker,
        receiver: HealReceiver,
        reception: HealReception,
    ): HealEffect {
        if (check.result) {
            receiver.hitPoints += invocation.heal
        }
        return HealEffect(receiver.hitPoints, reception.hitPoints, System.currentTimeMillis(), UUID.randomUUID())
    }

    override fun getInvocable(): Invocable<HealMoreInvoker, HealInvocation> {
        return HealMoreInvocable()
    }
}