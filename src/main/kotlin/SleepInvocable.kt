package com.github.lindsaygelle

class SleepInvocable(magicPoints: Int) : MagicInvocable<SleepInvoker, SleepInvocation>(magicPoints) {
    override fun invoke(invoker: SleepInvoker): SleepInvocation {
        return SleepInvocation(
            invoker.magicPoints,
            invoker.sleepRequirement,
            invoker.sleepRequirementMaximum,
            invoker.sleepRequirementMinimum
        )
    }
}