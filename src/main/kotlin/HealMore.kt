package com.github.lindsaygelle.dqbs

import kotlin.random.Random

class HealMore<I : HealMoreInvoker, R : HealReceiver>(
    limit: Int,
    magicCost: Int,
) : HealMagic<I, R>(limit, magicCost) {
    override fun getInvokerHeal(
        invoker: I,
        tracers: MutableCollection<Tracer>,
    ): Int {
        val healRangeMaximum = invoker.healRangeMaximum
        val healRangeMinimum = invoker.healRangeMinimum
        val healRandom = Random.nextInt(healRangeMinimum, healRangeMaximum)
        val healMoreOffset = healRandom and invoker.healMoreShift
        val healMoreScale = healMoreOffset + invoker.healMoreScale
        val healMore = maxOf(0, healMoreScale)
        tracers.add(
            HealMoreGet(
                healMore,
                healMoreOffset,
                healMoreScale,
                healRangeMaximum,
                healRangeMinimum,
                System.currentTimeMillis(),
                invoker.uuid,
            )
        )
        return healMore
    }
}