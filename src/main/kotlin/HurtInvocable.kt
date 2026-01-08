package com.github.lindsaygelle

import java.util.*

class HurtInvocable : MagicInvocable<HurtInvoker, HurtInvocation>() {
    override fun invoke(invoker: HurtInvoker): HurtInvocation {
        val hurtRandom = invoker.hurtRange.random()
        val hurtOffset = (hurtRandom and invoker.hurtShift) + invoker.hurtScale
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