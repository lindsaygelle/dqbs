package com.github.lindsaygelle

class SleepInvocable : Invocable<SleepInvoker>() {
    override fun invoke(invoker: SleepInvoker): Invocation {
        return SleepInvocation(
            invoker.sleepRequirementRange.random(),
            invoker.sleepRequirementMaximum,
            invoker.sleepRequirementMinimum
        )
    }
}
