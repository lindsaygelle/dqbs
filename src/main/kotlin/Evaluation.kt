package com.github.lindsaygelle.dqbs

import java.util.*

abstract class Evaluation<R : Actor>(
    protected val comparisons: Collection<Comparison<R>>,
) {
    protected val uuid: UUID = UUID.randomUUID()

    init {
        require(comparisons.isNotEmpty())
    }

    protected fun checkComparison(
        comparison: Comparison<R>,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return comparison.check(receiver, tracers)
    }
}