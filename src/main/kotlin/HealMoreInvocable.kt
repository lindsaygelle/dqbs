package com.github.lindsaygelle

import java.util.*

class HealMoreInvocable : MagicInvocable<HealMoreInvoker, HealInvocation>() {
    override fun invoke(invoker: HealMoreInvoker): HealInvocation {
        val healRandom = invoker.healRange.random()
        val healOffset = (healRandom and invoker.healMoreShift) + invoker.healMoreScale
        val heal = maxOf(0, healOffset)
        return HealInvocation(
            heal,
            healOffset,
            healRandom,
            invoker.healRangeMaximum,
            invoker.healRangeMinimum,
            invoker.magicPoints,
            System.currentTimeMillis(),
            UUID.randomUUID(),
        )
    }
}