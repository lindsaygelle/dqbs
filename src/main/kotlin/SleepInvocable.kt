package com.github.lindsaygelle

import java.util.*

class SleepInvocable : MagicInvocable<SleepInvoker, SleepInvocation>() {
    override fun invoke(invoker: SleepInvoker): SleepInvocation {
        return SleepInvocation(
            invoker.magicPoints,
            invoker.sleepRequirement,
            invoker.sleepRequirementMaximum,
            invoker.sleepRequirementMinimum,
            System.currentTimeMillis(),
            UUID.randomUUID(),
        )
    }
}