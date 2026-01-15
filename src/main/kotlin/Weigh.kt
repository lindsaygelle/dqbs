package com.github.lindsaygelle.dqbs

class Weigh<R : Actor>(
    comparisons: Collection<Comparison<R>>,
) : Evaluation<R>(comparisons),
    Sorter<R> {
    override fun sort(
        receivers: Collection<R>,
        tracers: MutableCollection<Tracer>,
    ): List<R> {
        tracers.add(
            WeighBegin(
                receivers.count(),
                System.currentTimeMillis(),
                uuid,
            )
        )
        val receivers = sortReceivers(comparisons, receivers, tracers)
        tracers.add(
            WeighEnd(
                receivers.count(),
                System.currentTimeMillis(),
                uuid,
            )
        )
        return receivers
    }

    private fun sortReceiver(
        comparisons: Collection<Comparison<R>>,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Int {
        var score = 0
        comparisons.forEach { comparison ->
            val result = checkComparison(comparison, receiver, tracers)
            score += if (result) 1 else 0
        }
        tracers.add(
            WeighCheck(
                receiver.uuid,
                score,
                System.currentTimeMillis(),
                uuid,
            )
        )
        return score
    }

    private fun sortReceivers(
        comparisons: Collection<Comparison<R>>,
        receivers: Collection<R>,
        tracers: MutableCollection<Tracer>,
    ): List<R> {
        return receivers.sortedByDescending { receiver ->
            sortReceiver(comparisons, receiver, tracers)
        }
    }
}