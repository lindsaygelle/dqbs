package com.github.lindsaygelle.dqbs

import kotlin.random.Random

class Heal<I : HealInvoker, R : HealReceiver>(
    limit: Int,
    magicPoints: Int,
) : HealMagic<I, R>(limit, magicPoints) {
    override fun getInvokerHeal(
        invoker: I,
        tracers: MutableCollection<Tracer>,
    ): Int {
        val healRangeMaximum = invoker.healRangeMaximum
        val healRangeMinimum = invoker.healRangeMinimum
        val healRandom = Random.nextInt(healRangeMinimum, healRangeMaximum)
        val healOffset = healRandom and invoker.healShift
        val healScale = healOffset + invoker.healScale
        val heal = maxOf(0, healScale)
        tracers.add(
            HealGet(
                heal,
                healOffset,
                healRangeMaximum,
                healRangeMinimum,
                healScale,
                System.currentTimeMillis(),
                invoker.uuid,
            )
        )
        return heal
    }
}