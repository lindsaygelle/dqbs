package com.github.lindsaygelle.dqbs

import java.util.*

class Weigh<R : Actor>(
    comparisons: Collection<Comparison<R>>,
    uuid: UUID,
) : Evaluation<R>(comparisons, uuid),
    Sorter<R> {
    override fun sort(
        receivers: Collection<R>,
        tracers: MutableCollection<Tracer>,
    ): List<R> {
        tracers.add(
            WeighBegin(
                receivers.count(),
                System.currentTimeMillis(),
                UUID.randomUUID(),
                uuid,
            )
        )
        val receivers = sortReceivers(comparisons, receivers, tracers)
        tracers.add(
            WeighEnd(
                receivers.count(),
                System.currentTimeMillis(),
                UUID.randomUUID(),
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
                UUID.randomUUID(),
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