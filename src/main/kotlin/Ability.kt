package com.github.lindsaygelle.dqbs

import java.util.*

abstract class Ability<I : AbilityInvoker, R : AbilityReceiver>(
    private val limit: Int,
) {
    protected val uuid: UUID = UUID.randomUUID()

    init {
        require(limit > 0)
    }

    private fun check(
        invoker: I,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return checkInvoker(invoker, tracers) && checkReceiver(receiver, tracers)
    }

    protected open fun checkInvoker(
        invoker: I,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return true
    }

    protected open fun checkReceiver(
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return true
    }

    abstract fun effect(
        invoker: I,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    )

    private fun tickReceiver(
        invoker: I,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        val result = check(invoker, receiver, tracers)
        if (result) {
            effect(invoker, receiver, tracers)
        }
        return result
    }

    private fun tickReceivers(
        invoker: I,
        receivers: Collection<R>,
        tracers: MutableCollection<Tracer>,
    ): Int {
        var count = 0
        receivers.forEach { receiver ->
            if (tickReceiver(invoker, receiver, tracers)) {
                count++
            }
        }
        return count
    }

    fun use(
        invoker: I,
        receivers: Collection<R>,
        tracers: MutableCollection<Tracer>,
    ) {
        tracers.add(
            AbilityBegin(
                invoker.uuid,
                limit,
                javaClass.simpleName,
                receivers.count(),
                System.currentTimeMillis(),
                uuid,
            )
        )
        val receivers = receivers.take(limit)
        val count = tickReceivers(invoker, receivers, tracers)
        tracers.add(
            AbilityEnd(
                count,
                invoker.uuid,
                javaClass.simpleName,
                receivers.count(),
                System.currentTimeMillis(),
                uuid,
            )
        )
    }
}