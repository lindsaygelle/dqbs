package com.github.lindsaygelle.dqbs

import java.util.*
import kotlin.random.Random

class Battle<T : Battler>(
    val invokers: Collection<T>,
) {
    var turn: Int = 0

    val uuid: UUID = UUID.randomUUID()

    init {
        require(invokers.isNotEmpty())
    }

    private fun checkInvokerSleep(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return checkInvokerTurnsSleepMaximum(invoker, tracers) || checkInvokerTurnsSleepMinimum(
            invoker, tracers
        ) && checkInvokerSleepResolution(invoker, tracers)
    }

    private fun checkInvokerSleepResolution(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        val sleepResolutionMaximum = invoker.sleepResolutionMaximum
        val sleepResolutionMinimum = invoker.sleepResolutionMinimum
        val sleepResolution = Random.nextInt(sleepResolutionMinimum, sleepResolutionMaximum)
        val result = sleepResolution == sleepResolutionMaximum
        tracers.add(
            SleepResolutionCheck(
                result,
                sleepResolution,
                sleepResolutionMaximum,
                sleepResolutionMinimum,
                System.currentTimeMillis(),
                invoker.uuid,
            )
        )
        return result
    }

    private fun checkInvokerStatusSleep(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        val result = invoker.statusSleep
        tracers.add(
            StatusSleepCheck(
                result,
                System.currentTimeMillis(),
                invoker.uuid,
            )
        )
        return result
    }

    private fun checkInvokerTurnsSleepMaximum(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        val turnsSleep = invoker.turnsSleep
        val turnsSleepMaximum = invoker.turnsSleepMaximum
        val result = turnsSleep >= turnsSleepMaximum
        tracers.add(
            TurnsSleepMaximumCheck(
                result,
                System.currentTimeMillis(),
                turnsSleep,
                turnsSleepMaximum,
                invoker.uuid,
            )
        )
        return result
    }

    private fun checkInvokerTurnsSleepMinimum(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        val turnsSleep = invoker.turnsSleep
        val turnsSleepMinimum = invoker.turnsSleepMinimum
        val result = turnsSleep >= turnsSleepMinimum
        tracers.add(
            TurnsSleepMinimumCheck(
                result,
                System.currentTimeMillis(),
                turnsSleep,
                turnsSleepMinimum,
                invoker.uuid,
            )
        )
        return result
    }

    private fun effectInvokerStatusSleep(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ) {
        val statusSleepPrevious = invoker.statusSleep
        invoker.statusSleep = false
        tracers.add(
            StatusSleepChange(
                invoker.statusSleep,
                statusSleepPrevious,
                System.currentTimeMillis(),
                invoker.uuid,
            )
        )
    }

    private fun checkInvokerStatusStopSpell(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        val result = invoker.statusStopSpell
        tracers.add(
            StatusStopSpellCheck(
                result,
                System.currentTimeMillis(),
                invoker.uuid,
            )
        )
        return result
    }

    private fun checkInvokerStopSpell(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return checkInvokerTurnsStopSpellMaximum(invoker, tracers) || checkInvokerTurnsStopSpellMinimum(
            invoker, tracers
        ) && checkInvokerStopSpellResolution(invoker, tracers)
    }

    private fun checkInvokerStopSpellResolution(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        val stopSpellResolutionMaximum = invoker.stopSpellResolutionMaximum
        val stopSpellResolutionMinimum = invoker.stopSpellResolutionMinimum
        val stopSpellResolution = Random.nextInt(stopSpellResolutionMinimum, stopSpellResolutionMaximum)
        val result = stopSpellResolution == stopSpellResolutionMaximum
        tracers.add(
            StopSpellResolutionCheck(
                result,
                stopSpellResolution,
                stopSpellResolutionMaximum,
                stopSpellResolutionMinimum,
                System.currentTimeMillis(),
                invoker.uuid,
            )
        )
        return result
    }

    private fun effectInvokerTurnsSleep(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ) {
        val turnsSleepPrevious = invoker.turnsSleep
        invoker.turnsSleep = if (invoker.statusSleep) invoker.turnsSleep++ else 0
        tracers.add(
            TurnsSleepChange(
                invoker.turnsSleep,
                turnsSleepPrevious,
                System.currentTimeMillis(),
                invoker.uuid,
            )
        )
    }

    private fun checkInvokerTurnsStopSpellMaximum(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        val turnsStopSpell = invoker.turnsStopSpell
        val turnsStopSpellMaximum = invoker.turnsStopSpellMaximum
        val result = turnsStopSpell >= turnsStopSpellMaximum
        tracers.add(
            TurnsStopSpellMaximumCheck(
                result,
                System.currentTimeMillis(),
                turnsStopSpell,
                turnsStopSpellMaximum,
                invoker.uuid,
            )
        )
        return result
    }

    private fun checkInvokerTurnsStopSpellMinimum(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        val turnsStopSpell = invoker.turnsStopSpell
        val turnsStopSpellMinimum = invoker.turnsStopSpellMinimum
        val result = turnsStopSpell >= turnsStopSpellMinimum
        tracers.add(
            TurnsStopSpellMinimumCheck(
                result,
                System.currentTimeMillis(),
                turnsStopSpell,
                turnsStopSpellMinimum,
                invoker.uuid,
            )
        )
        return result
    }

    private fun effectInvokerStatusStopSpell(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ) {
        val statusStopSpellPrevious = invoker.statusStopSpell
        invoker.statusStopSpell = false
        tracers.add(
            StatusStopSpellChange(
                invoker.statusStopSpell,
                statusStopSpellPrevious,
                System.currentTimeMillis(),
                invoker.uuid,
            )
        )
    }

    private fun effectInvokerTurnsStopSpell(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ) {
        val turnsStopSpellPrevious = invoker.turnsStopSpell
        invoker.turnsStopSpell = if (invoker.statusStopSpell) invoker.turnsStopSpell++ else 0
        tracers.add(
            TurnsStopSpellChange(
                invoker.turnsStopSpell,
                turnsStopSpellPrevious,
                System.currentTimeMillis(),
                invoker.uuid,
            )
        )
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
        invoker.actions.withIndex().any { (_, action) ->
            action.use(invoker, receivers, tracers)
        }
    }

    private fun tickInvokerSleep(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ) {
        tracers.add(
            TurnSleep(
                invoker.uuid,
                turn,
                System.currentTimeMillis(),
                uuid,
            )
        )
        if (checkInvokerStatusSleep(invoker, tracers)) {
            if (checkInvokerSleep(invoker, tracers)) {
                effectInvokerStatusSleep(invoker, tracers)
            }
            effectInvokerTurnsSleep(invoker, tracers)
        }
    }

    private fun tickInvokerStopSpell(
        invoker: T,
        tracers: MutableCollection<Tracer>,
    ) {
        tracers.add(
            TurnStopSpell(
                invoker.uuid,
                System.currentTimeMillis(),
                turn,
                uuid,
            )
        )
        if (checkInvokerStatusStopSpell(invoker, tracers)) {
            if (checkInvokerStopSpell(invoker, tracers)) {
                effectInvokerStatusStopSpell(invoker, tracers)
            }
            effectInvokerTurnsStopSpell(invoker, tracers)
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