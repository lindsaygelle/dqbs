package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Ability<A : Invoker, B : Receiver>(
    limit: Int,
) : Limiter {


    final override var limit: Int = limit
        set(value) {
            field = maxOf(1, value)
            logger.trace("limit={}", field)
        }

    @Transient
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    init {
        this.limit = limit
    }

    /*
    protected fun getCheck(checkable: Checkable, invocation: Invocation, reception: Reception): Check {
        return checkable.check(invocation, reception)
    }

    protected abstract fun getInvocation(invocable: Invocable<A, Invocation>, invoker: A): Invocation
    */
    protected abstract fun getOutcome(invoker: A, receiver: B, receiverIndex: Int): Outcome
    /*
    protected abstract fun getReception(receivable: Receivable<B, Reception>): Reception
    */
    fun use(invoker: A, receivers: List<B>): List<Outcome> {
        return receivers.take(limit).mapIndexed { receiverIndex, receiver ->
            getOutcome(invoker, receiver, receiverIndex)
        }
    }

    /*
    override fun toString(): String {
        return "checkable=${checkable} hashCode=${hashCode()} invocable=${invocable} limit=${limit} receivable=${receivable}"
    }
     */

}