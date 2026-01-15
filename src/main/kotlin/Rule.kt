package com.github.lindsaygelle.dqbs

class Rule<R : Actor>(
    comparisons: Collection<Comparison<R>>,
    private val match: Match,
) : Evaluation<R>(
    comparisons
),
    Checker<R> {
    override fun check(
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        tracers.add(
            RuleBegin(
                match,
                receiver.uuid,
                System.currentTimeMillis(),
                uuid,
            )
        )
        val result = checkMatch(
            comparisons.withIndex(), receiver, tracers
        )
        tracers.add(
            RuleEnd(
                match,
                receiver.uuid,
                result,
                System.currentTimeMillis(),
                uuid,
            )
        )
        return result
    }

    private fun checkAll(
        comparisons: Iterable<IndexedValue<Comparison<R>>>,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return checkComparisons(
            comparisons::all, receiver, tracers
        )
    }

    private fun checkAny(
        comparisons: Iterable<IndexedValue<Comparison<R>>>,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return checkComparisons(
            comparisons::any, receiver, tracers
        )
    }

    private fun checkComparisons(
        comparisons: ((predicate: IndexedValue<Comparison<R>>) -> Boolean) -> Boolean,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        var count = 0
        val result = comparisons { (comparisonIndex, comparison) ->
            count = comparisonIndex
            checkComparison(
                comparison, receiver, tracers
            )
        }
        tracers.add(
            RuleCheck(
                count,
                match,
                receiver.uuid,
                result,
                System.currentTimeMillis(),
                uuid,
            )
        )
        return result
    }

    private fun checkMatch(
        comparisons: Iterable<IndexedValue<Comparison<R>>>,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return when (match) {
            Match.ALL -> checkAll(
                comparisons, receiver, tracers
            )

            Match.ANY -> checkAny(
                comparisons, receiver, tracers
            )
        }
    }
}