package com.github.lindsaygelle.dqbs

import java.util.*

class Action<I : Actor, R : Actor>(
    var ability: Ability<I, R>,
    var assess: Case<I, R>,
    var choose: Case<I, R>,
    override var uuid: UUID,
    var weigh: Weigh<R>,
) : UniversalIdentifier {
    fun use(
        invoker: I,
        receivers: Collection<R>,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        tracers.add(
            ActionBegin(
                uuid,
                invoker.uuid,
                receivers.count(),
                System.currentTimeMillis(),
                UUID.randomUUID(),
            )
        )
        var filteredReceivers = assess.filter(invoker, receivers, tracers)
        var result = filteredReceivers.isNotEmpty()
        if (result) {
            filteredReceivers = choose.filter(invoker, receivers, tracers)
            result = filteredReceivers.isNotEmpty()
            if (result) {
                filteredReceivers = weigh.sort(receivers, tracers)
                result = ability.use(invoker, filteredReceivers, tracers)
            }
        }
        tracers.add(
            ActionEnd(
                uuid,
                invoker.uuid,
                result,
                System.currentTimeMillis(),
                UUID.randomUUID(),
            )
        )
        return result
    }
}