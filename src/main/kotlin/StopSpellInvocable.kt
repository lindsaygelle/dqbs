package com.github.lindsaygelle

import java.util.*

class StopSpellInvocable(magicPoints: Int) : MagicInvocable<StopSpellInvoker, StopSpellInvocation>(magicPoints) {
    override fun invoke(invoker: StopSpellInvoker): StopSpellInvocation {
        return StopSpellInvocation(
            invoker.magicPoints,
            invoker.stopSpellRequirement,
            invoker.stopSpellRequirementMaximum,
            invoker.stopSpellRequirementMinimum,
            System.currentTimeMillis(),
            UUID.randomUUID(),
        )
    }
}