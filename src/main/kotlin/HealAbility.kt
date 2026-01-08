package com.github.lindsaygelle

abstract class HealAbility<A>(
    limit: Int,
    magicPoints: Int,
) : MagicAbility<A, HealReceiver, HealInvocation, HealReception, HealCheck, HealEffect>(
    limit, magicPoints
) where A : MagicInvoker, A : HealRanger {
    final override fun getCheckable(): Checkable<HealInvocation, HealReception, HealCheck> {
        return HealCheckable(magicPoints)
    }

    final override fun getReceivable(): Receivable<HealReceiver, HealReception> {
        return HealReceivable()
    }
}