package com.github.lindsaygelle

abstract class HurtAbility<A>(
    limit: Int,
    magicPoints: Int
) : MagicAbility<A, HurtReceiver, HurtInvocation, HurtReception, HurtCheck, HurtEffect>(
    limit,
    magicPoints
) where A : MagicInvoker, A : HurtRequirer {
    final override fun getCheckable(): Checkable<HurtInvocation, HurtReception, HurtCheck> {
        return HurtCheckable(magicPoints)
    }

    final override fun getReceivable(): Receivable<HurtReceiver, HurtReception> {
        return HurtReceivable()
    }
}