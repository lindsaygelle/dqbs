package com.github.lindsaygelle

import java.util.*

class HealInvocable(magicPoints: Int) : MagicInvocable<HealInvoker, HealInvocation>(magicPoints) {
    override fun invoke(invoker: HealInvoker): HealInvocation {
        val healRandom = invoker.healRange.random()
        val healOffset = (healRandom and invoker.healShift) + invoker.healScale
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