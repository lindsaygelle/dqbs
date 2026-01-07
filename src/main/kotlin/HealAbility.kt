package com.github.lindsaygelle

abstract class HealAbility<A: MagicInvoker>(
    limit: Int,
    magicPoints: Int
) : MagicAbility<A, HealReceiver, HealInvocation, HealReception, HealCheck, HealEffect>(
    limit,
    magicPoints
) {
    final override fun getCheckable(): Checkable<HealInvocation, HealReception, HealCheck> {
        return HealCheckable(magicPoints)
    }

    final override fun getReceivable(): Receivable<HealReceiver, HealReception> {
        return HealReceivable()
    }
}