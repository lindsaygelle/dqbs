package com.github.lindsaygelle.dqbs

import java.util.*

class Action<I : Actor, R : Actor>(
    private val ability: Ability<I, R>,
    private val assess: Qualify<I, R>,
    private val choose: Qualify<I, R>,
    val priority: Int,
    private val weigh: Weigh<R>,
) {
    private val uuid: UUID = UUID.randomUUID()

    fun use(
        invoker: I,
        receivers: Collection<R>,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        tracers.add(
            ActionBegin(
                invoker.uuid,
                receivers.count(),
                System.currentTimeMillis(),
                uuid,
            )
        )
        var filteredReceivers = assess.filter(invoker, receivers, tracers)
        var filteredReceiversCount = filteredReceivers.count()
        var result = filteredReceiversCount > 0
        tracers.add(
            AssessEnd(
                invoker.uuid,
                filteredReceiversCount,
                result,
                System.currentTimeMillis(),
                uuid,
            )
        )
        if (result) {
            filteredReceivers = choose.filter(invoker, receivers, tracers)
            filteredReceiversCount = filteredReceivers.count()
            result = filteredReceiversCount > 0
            tracers.add(
                ChooseEnd(
                    invoker.uuid, filteredReceiversCount, System.currentTimeMillis(), uuid
                )
            )
            if (result) {
                filteredReceivers = weigh.sort(filteredReceivers, tracers)
                ability.use(invoker, filteredReceivers, tracers)
            }
        }
        tracers.add(
            ActionEnd(
                invoker.uuid,
                result,
                System.currentTimeMillis(),
                uuid,
            )
        )
        return result
    }
}