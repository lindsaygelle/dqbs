package com.github.lindsaygelle.dqbs

import kotlin.random.Random

class StopSpell<I : StopSpellInvoker, R : StopSpellReceiver>(
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
            effectReceiverStatusStopSpell(receiver, tracers)
        }
    }

    private fun effectReceiverStatusStopSpell(
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ) {
        val statusStopSpellPrevious = receiver.statusStopSpell
        receiver.statusStopSpell = true
        tracers.add(
            StopSpellStatusChange(
                receiver.statusStopSpell,
                statusStopSpellPrevious,
                System.currentTimeMillis(),
                receiver.uuid,
            )
        )
    }

    override fun getRequirement(
        invoker: I,
        tracers: MutableCollection<Tracer>,
    ): Int {
        val stopSpellRequirementMaximum = invoker.stopSpellRequirementMaximum
        val stopSpellRequirementMinimum = invoker.stopSpellRequirementMinimum
        val stopSpellRequirement = Random.nextInt(stopSpellRequirementMinimum, stopSpellRequirementMaximum)
        tracers.add(
            StopSpellRequirementGet(
                stopSpellRequirement,
                stopSpellRequirementMaximum,
                stopSpellRequirementMinimum,
                System.currentTimeMillis(),
                invoker.uuid
            )
        )
        return stopSpellRequirement
    }

    override fun getResistance(
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Int {
        val stopSpellResistanceMaximum = receiver.stopSpellResistanceMaximum
        val stopSpellResistanceMinimum = receiver.stopSpellResistanceMinimum
        val stopSpellResistance = Random.nextInt(stopSpellResistanceMinimum, stopSpellResistanceMaximum)
        tracers.add(
            StopSpellResistanceGet(
                stopSpellResistance,
                stopSpellResistanceMaximum,
                stopSpellResistanceMinimum,
                System.currentTimeMillis(),
                receiver.uuid
            )
        )
        return stopSpellResistance
    }
}