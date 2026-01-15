package com.github.lindsaygelle.dqbs

abstract class HealMagic<I, R : HealReceiver>(
    limit: Int,
    magicCost: Int,
) : MagicAbility<I, R>(limit, magicCost) where I : HealApplier, I : MagicInvoker {
    final override fun effect(
        invoker: I,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ) {
        super.effect(invoker, receiver, tracers)
        val heal = getInvokerHeal(invoker, tracers)
        effectReceiverHitPoints(heal, receiver, tracers)
    }

    private fun effectReceiverHitPoints(
        heal: Int,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ) {
        val hitPointsPrevious = receiver.hitPoints
        receiver.hitPoints += heal
        tracers.add(
            HitPointsChange(
                receiver.hitPoints,
                hitPointsPrevious,
                System.currentTimeMillis(),
                receiver.uuid,
            )
        )
    }

    protected abstract fun getInvokerHeal(
        invoker: I,
        tracers: MutableCollection<Tracer>,
    ): Int
}