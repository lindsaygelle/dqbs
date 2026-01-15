package com.github.lindsaygelle.dqbs

abstract class RequirementMagic<I : MagicInvoker, R : AbilityReceiver>(
    limit: Int,
    magicCost: Int,
) : MagicAbility<I, R>(limit, magicCost) {
    protected fun checkRequirement(
        invoker: I,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return getRequirement(invoker, tracers) >= getResistance(receiver, tracers)
    }

    protected abstract fun getRequirement(
        invoker: I,
        tracers: MutableCollection<Tracer>,
    ): Int

    protected abstract fun getResistance(
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Int
}