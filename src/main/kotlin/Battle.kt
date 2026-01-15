package com.github.lindsaygelle.dqbs

import java.util.*

class Battle<T : Battler>(
    var invokers: Collection<T>,
    override var uuid: UUID,
) : TurnAccumulator,
    UniversalIdentifier {
    override var turn: Int = 0

    private fun filterInvoker(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        val result = true
        tracers.add(
            TurnFilter(
                uuid,
                invoker.uuid,
                result,
                System.currentTimeMillis(),
                turn,
                UUID.randomUUID(),
            )
        )
        return result
    }

    private fun filterInvokers(
        invokers: Collection<T>,
        tracers: MutableCollection<Tracer>,
    ): Collection<T> {
        return invokers.filter { invoker ->
            filterInvoker(invoker, tracers)
        }
    }

    private fun sortInvoker(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ): Int {
        val score = invoker.agility
        tracers.add(
            TurnSort(
                uuid,
                invoker.uuid,
                score,
                System.currentTimeMillis(), 
                UUID.randomUUID(),
                turn,
            )
        )
        return score
    }

    private fun sortInvokers(
        invokers: Collection<T>,
        tracers: MutableCollection<Tracer>,
    ): Collection<T> {
        return invokers.sortedByDescending { invoker ->
            sortInvoker(invoker, tracers)
        }
    }

    fun tick(): Collection<Tracer> {
        val tracers = mutableListOf<Tracer>()
        tracers.add(
            TurnBegin(
                uuid,
                invokers.count(),
                System.currentTimeMillis(),
                turn,
                UUID.randomUUID(),
            )
        )
        var filteredInvokers = filterInvokers(invokers, tracers)
        filteredInvokers = sortInvokers(filteredInvokers, tracers)
        tickInvokers(filteredInvokers.iterator(), invokers, tracers)
        tracers.add(
            TurnEnd(
                uuid,
                System.currentTimeMillis(),
                turn,
                UUID.randomUUID(),
            )
        )
        turn++
        return tracers
    }

    private fun tickInvoker(
        invoker: T,
        receivers: Collection<T>,
        tracers: MutableCollection<Tracer>,
    ) {
        invoker.actions.any { action ->
            action.use(invoker, receivers, tracers)
        }
    }

    private fun tickInvokers(
        invokers: Iterator<T>,
        receivers: Collection<T>,
        tracers: MutableCollection<Tracer>,
    ) {
        while (invokers.hasNext()) {
            tickInvoker(invokers.next(), receivers, tracers)
        }
    }
}