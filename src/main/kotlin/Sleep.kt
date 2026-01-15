package com.github.lindsaygelle.dqbs

import kotlin.random.Random

class Sleep<I : SleepInvoker, R : SleepReceiver>(
    limit: Int,
    magicCost: Int,
) : RequirementMagic<I, R>(limit, magicCost) {
    override fun effect(
        invoker: I,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ) {
        super.effect(invoker, receiver, tracers)
        if (checkRequirement(invoker, receiver, tracers)) {
            effectReceiverStatusSleep(receiver, tracers)
        }
    }

    private fun effectReceiverStatusSleep(
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ) {
        receiver.statusSleep = true
        tracers.add(
            SleepStatusChange(
                receiver.statusSleep,
                System.currentTimeMillis(),
                receiver.uuid,
            )
        )
    }

    override fun getRequirement(
        invoker: I,
        tracers: MutableCollection<Tracer>,
    ): Int {
        val sleepRequirementMaximum = invoker.sleepRequirementMaximum
        val sleepRequirementMinimum = invoker.sleepRequirementMinimum
        val sleepRequirement = Random.nextInt(
            sleepRequirementMinimum, sleepRequirementMaximum
        )
        tracers.add(
            SleepRequirementGet(
                sleepRequirement,
                sleepRequirementMaximum,
                sleepRequirementMinimum,
                System.currentTimeMillis(),
                invoker.uuid,
            )
        )
        return sleepRequirement
    }

    override fun getResistance(
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Int {
        val sleepResistanceMaximum = receiver.sleepResistanceMaximum
        val sleepResistanceMinimum = receiver.sleepResistanceMinimum
        val sleepResistance = Random.nextInt(
            sleepResistanceMinimum, sleepResistanceMaximum
        )
        tracers.add(
            SleepResistanceGet(
                sleepResistance,
                sleepResistanceMaximum,
                sleepResistanceMinimum,
                System.currentTimeMillis(),
                receiver.uuid
            )
        )
        return sleepResistance
    }
}