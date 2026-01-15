package com.github.lindsaygelle.dqbs

import java.util.*

class Case<I : Actor, R : Actor>(
    var rules: Collection<Rule<R>>,
    var selections: Collection<Selection>,
    override var uuid: UUID,
) : UniversalIdentifier {
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
                uuid,
                count,
                invoker.uuid,
                receiver.uuid,
                result,
                System.currentTimeMillis(),
                UUID.randomUUID(),
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
                uuid,
                invoker.uuid,
                receiver.uuid,
                result,
                selection,
                System.currentTimeMillis(),
                UUID.randomUUID(),
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
    ): List<R> {
        tracers.add(
            CaseBegin(
                uuid,
                invoker.uuid,
                receivers.count(),
                System.currentTimeMillis(),
                UUID.randomUUID(),
            )
        )
        val receivers = filterReceivers(
            invoker, receivers, rules, selections, tracers
        )
        tracers.add(
            CaseEnd(
                uuid,
                invoker.uuid,
                receivers.count(),
                System.currentTimeMillis(),
                UUID.randomUUID(),
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