package com.github.lindsaygelle.dqbs

import java.util.*

class Battle<T : Battler>(
    val invokers: Collection<T>,
) {
    var turn: Int = 0

    val uuid: UUID = UUID.randomUUID()

    init {
        require(invokers.isNotEmpty())
    }

    private fun filterInvoker(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        val result = true
        tracers.add(
            TurnFilter(
                invoker.uuid,
                result,
                System.currentTimeMillis(),
                turn,
                uuid,
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
                invoker.uuid,
                score,
                System.currentTimeMillis(),
                turn,
                uuid,
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
                invokers.count(),
                System.currentTimeMillis(),
                turn,
                uuid,
            )
        )
        var filteredInvokers = filterInvokers(invokers, tracers)
        filteredInvokers = sortInvokers(filteredInvokers, tracers)
        tickInvokers(filteredInvokers.iterator(), invokers, tracers)
        tracers.add(
            TurnEnd(
                System.currentTimeMillis(),
                turn,
                uuid,
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
        tickInvokerSleep(invoker, tracers)
        tickInvokerStopSpell(invoker, tracers)
        tickInvokerActions(invoker, receivers, tracers)
    }

    private fun tickInvokerActions(
        invoker: T,
        receivers: Collection<T>,
        tracers: MutableCollection<Tracer>,
    ) {
        invoker.actions.withIndex().any { (actionIndex, action) ->
            action.use(invoker, receivers, tracers)
        }
    }

    private fun tickInvokerSleep(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ) {

    }

    private fun tickInvokerStopSpell(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ) {
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