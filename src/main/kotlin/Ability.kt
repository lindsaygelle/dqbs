package com.github.lindsaygelle.dqbs

import java.util.*

open class Ability<I : Invoker, R : Receiver>(
    override var limit: Int,
    override var uuid: UUID,
) : Limiter,
    NameProvider,
    UniversalIdentifier {
    protected open fun apply(
        invoker: I,
        receiver: R,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return true
    }

    private fun check(
        invoker: I,
        receivers: Collection<R>,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        return receivers.all { receiver ->
            (checkInvoker(invoker, tracers) && checkReceiver(receiver, tracers)) && apply(invoker, receiver, tracers)
        }
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

    fun use(
        invoker: I,
        receivers: Collection<R>,
        tracers: MutableCollection<Tracer>,
    ): Boolean {
        tracers.add(
            AbilityBegin(
                uuid,
                invoker.uuid,
                limit,
                name,
                receivers.count(),
                System.currentTimeMillis(),
                UUID.randomUUID(),
            )
        )
        val result = check(invoker, receivers.take(limit), tracers)
        tracers.add(
            AbilityEnd(
                uuid,
                invoker.uuid,
                name,
                result,
                System.currentTimeMillis(),
                UUID.randomUUID(),
            )
        )
        return result
    }
}