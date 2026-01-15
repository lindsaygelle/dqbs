package com.github.lindsaygelle.dqbs

import java.util.*

class Qualify<I : Actor, R : Actor>(
    private val cases: Collection<Case<I, R>>,
) {
    private val uuid: UUID = UUID.randomUUID()

    init {
        require(cases.isNotEmpty())
    }

    fun filter(
        invoker: I,
        receivers: Collection<R>,
        tracers: MutableCollection<Tracer>,
    ): Collection<R> {
        tracers.add(
            QualifyBegin(
                invoker.uuid,
                receivers.count(),
                System.currentTimeMillis(),
                uuid,
            )
        )
        var count = 0
        var filteredReceivers: Collection<R> = receivers
        for ((caseIndex, case) in cases.withIndex()) {
            count = caseIndex
            filteredReceivers = case.filter(invoker, filteredReceivers, tracers)
            if (filteredReceivers.isEmpty()) break
        }
        tracers.add(
            QualifyEnd(
                count,
                invoker.uuid,
                filteredReceivers.count(),
                filteredReceivers.isNotEmpty(),
                System.currentTimeMillis(),
                uuid
            )
        )
        return filteredReceivers
    }
}