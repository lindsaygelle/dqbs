package com.github.lindsaygelle.dqbs

import java.util.*

abstract class Evaluation<R : Actor>(
    var comparisons: Collection<Comparison<R>>,
    override var uuid: UUID,
) : UniversalIdentifier {
    protected fun checkComparison(
        comparison: Comparison<R>,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return comparison.check(receiver, tracers)
    }
}