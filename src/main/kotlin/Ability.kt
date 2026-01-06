package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Ability<A : Invoker, B : Receiver>(
    checkable: Checkable<A, B>,
    invocable: Invocable<A>,
    limit: Int,
    receivable: Receivable<B>
) :
    Limiter {
    var checkable: Checkable<A, B> = checkable
        set(value) {
            field = value
            logger.trace("checkable={}", field)
        }

    var invocable: Invocable<A> = invocable
        set(value) {
            field = value
            logger.trace("invocable={}", field)
        }

    final override var limit: Int = limit
        set(value) {
            field = maxOf(0, value)
            logger.trace("limit={}", field)
        }

    @Transient
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    var receivable: Receivable<B> = receivable
        set(value) {
            field = value
            logger.trace("receivable={}", field)
        }

    init {
        this.checkable = checkable
        this.invocable = invocable
        this.limit = limit
        this.receivable = receivable
    }


    override fun toString(): String {
        return "checkable=${checkable} hashCode=${hashCode()} invocable=${invocable} limit=${limit} receivable=${receivable}"
    }

    fun use(invoker: A, receivers: List<B>): List<Outcome> {
        val outcomes = mutableListOf<Outcome>()
        receivers.take(limit).forEachIndexed { _, receiver ->
            val invocation = invocable.invoke(invoker)
            receivable.receive(receiver)
        }
        return outcomes
    }
}