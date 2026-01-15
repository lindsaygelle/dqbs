package com.github.lindsaygelle.dqbs

import java.util.*

class Case<I : Actor, R : Actor>(
    private val rules: Collection<Rule<R>>,
    private val selections: Collection<Selection>,
) {
    private val uuid: UUID = UUID.randomUUID()

    init {
        require(rules.isNotEmpty())
        require(selections.isNotEmpty())
    }

    private fun checkRule(
        receiver: R,
        rule: Rule<R>,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return rule.check(receiver, tracers)
    }

    private fun checkRules(
        invoker: I,
        receiver: R,
        rules: Collection<Rule<R>>,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        var count = 0
        val result = rules.withIndex().all { (index, rule) ->
            count = index
            checkRule(receiver, rule, tracers)
        }
        tracers.add(
            CaseCheck(
                count,
                invoker.uuid,
                receiver.uuid,
                result,
                System.currentTimeMillis(),
                uuid,
            )
        )
        return result
    }

    private fun checkSelection(
        invoker: I,
        receiver: R,
        selection: Selection,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        val result = when (selection) {
            Selection.ALLY -> invoker.allegiance == receiver.allegiance
            Selection.ENEMY -> invoker.allegiance != receiver.allegiance
            Selection.SELF -> invoker == receiver
        }
        tracers.add(
            CaseSelect(
                invoker.uuid,
                receiver.uuid,
                result,
                selection,
                System.currentTimeMillis(),
                uuid,
            )
        )
        return result
    }

    private fun checkSelections(
        invoker: I,
        receiver: R,
        selections: Collection<Selection>,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return selections.all { selection ->
            checkSelection(invoker, receiver, selection, tracers)
        }
    }

    fun filter(
        invoker: I,
        receivers: Collection<R>,
        tracers: MutableCollection<Tracer>,
    ): Collection<R> {
        tracers.add(
            CaseBegin(
                invoker.uuid,
                receivers.count(),
                System.currentTimeMillis(),
                uuid,
            )
        )
        val receivers = filterReceivers(
            invoker, receivers, rules, selections, tracers
        )
        tracers.add(
            CaseEnd(
                invoker.uuid,
                receivers.count(),
                System.currentTimeMillis(),
                uuid,
            )
        )
        return receivers
    }

    private fun filterReceivers(
        invoker: I,
        receivers: Collection<R>,
        rules: Collection<Rule<R>>,
        selections: Collection<Selection>,
        tracers: MutableCollection<Tracer>,
    ): List<R> {
        return receivers.filter { receiver ->
            (checkSelections(invoker, receiver, selections, tracers) && checkRules(invoker, receiver, rules, tracers))
        }
    }
}