package com.github.lindsaygelle

import java.util.*

class StopSpellInvocable : MagicInvocable<StopSpellInvoker, StopSpellInvocation>() {
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