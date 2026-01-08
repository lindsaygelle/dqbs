package com.github.lindsaygelle

import java.util.*

class HurtMoreInvocable : MagicInvocable<HurtMoreInvoker, HurtInvocation>() {
    override fun invoke(invoker: HurtMoreInvoker): HurtInvocation {
        val hurtRandom = invoker.hurtRange.random()
        val hurtOffset = (hurtRandom and invoker.hurtMoreShift) + invoker.hurtMoreScale
        val hurt = maxOf(0, hurtOffset)
        return HurtInvocation(
            hurt,
            hurtOffset,
            hurtRandom,
            invoker.hurtRequirement,
            invoker.hurtRequirementMaximum,
            invoker.hurtRequirementMinimum,
            invoker.magicPoints,
            System.currentTimeMillis(),
            UUID.randomUUID(),
        )
    }
}