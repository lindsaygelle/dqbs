package com.github.lindsaygelle

import java.util.*

class HurtInvocable : MagicInvocable<HurtInvoker, HurtInvocation>() {
    override fun invoke(invoker: HurtInvoker): HurtInvocation {
        return HurtInvocation(
            invoker.hurtRequirement,
            invoker.hurtRequirementMaximum,
            invoker.hurtRequirementMinimum,
            invoker.magicPoints,
            System.currentTimeMillis(),
            UUID.randomUUID(),
        )
    }
}