package com.github.lindsaygelle.dqbs

open class MagicAbility<I : MagicInvoker, R : AbilityReceiver>(
    limit: Int,
    protected val magicCost: Int,
) : Ability<I, R>(limit) {
    override fun checkInvoker(
        invoker: I,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return super.checkInvoker(invoker, tracers) && checkInvokerMagicPoints(
            invoker, tracers
        ) && checkInvokerStopSpellStatus(invoker, tracers)
    }

    private fun checkInvokerMagicPoints(
        invoker: I,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        val magicPoints = invoker.magicPoints - magicCost
        val result = magicPoints > -1
        tracers.add(
            MagicCostCheck(
                magicCost,
                javaClass.simpleName,
                invoker.magicPoints,
                invoker.uuid,
                result,
                System.currentTimeMillis(),
                uuid,
            )
        )
        return result
    }

    private fun checkInvokerStopSpellStatus(
        invoker: I,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        val result = !invoker.statusStopSpell
        tracers.add(
            StatusStopSpellCheck(
                result,
                System.currentTimeMillis(),
                invoker.uuid,
            )
        )
        return result
    }

    override fun effect(
        invoker: I,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ) {
        effectInvokerMagicCost(invoker, tracers)
    }

    private fun effectInvokerMagicCost(
        invoker: I,
        tracers: MutableCollection<Tracer>,
    ) {
        val magicPointsPrevious = invoker.magicPoints
        invoker.magicPoints -= magicCost
        tracers.add(
            MagicPointsChange(
                invoker.magicPoints,
                magicPointsPrevious,
                System.currentTimeMillis(),
                invoker.uuid,
            )
        )
    }
}