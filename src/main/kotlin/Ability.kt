package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

abstract class Ability<A : Invoker, B : Receiver, I : Invocation, R : Reception, C : Check, E : Effect>(
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

    private fun getCheck(
        checkable: Checkable<I, R, C>, invocation: I, reception: R
    ): C {
        logger.debug("checkable={} invocation={} reception={}", checkable, invocation, reception)
        return checkable.check(invocation, reception)
    }

    protected abstract fun getCheckable(): Checkable<I, R, C>

    protected abstract fun getEffect(check: C, invocation: I, invoker: A, receiver: B, reception: R): E

    protected abstract fun getInvocable(): Invocable<A, I>

    private fun getInvocation(invocable: Invocable<A, I>, invoker: A): I {
        logger.debug("invocable={} invoker={}", invocable, invoker)
        return invocable.invoke(invoker)
    }

    private fun getOutcome(invoker: A, receiver: B, receiverIndex: Int): Outcome<C, E, I, R> {
        logger.debug("invoker={} receiver={} receiverIndex={}", invoker, receiver, receiverIndex)
        val invocable = getInvocable()
        val receivable = getReceivable()
        val invocation = getInvocation(invocable, invoker)
        val reception = getReception(receivable, receiver)
        val checkable = getCheckable()
        val check = getCheck(checkable, invocation, reception)
        val effect = getEffect(check, invocation, invoker, receiver, reception)
        return Outcome(
            check,
            effect,
            invocation,
            invoker.uuid,
            receiverIndex,
            receiver.uuid,
            reception,
            System.currentTimeMillis(),
            UUID.randomUUID()
        )
    }

    protected abstract fun getReceivable(): Receivable<B, R>
    private fun getReception(receivable: Receivable<B, R>, receiver: B): R {
        logger.debug("receivable={} receiver={}", receivable, receiver)
        return receivable.receive(receiver)
    }

    fun use(invoker: A, receivers: List<B>): List<Outcome<C, E, I, R>> {
        return receivers.take(limit).mapIndexed { receiverIndex, receiver ->
            getOutcome(invoker, receiver, receiverIndex)
        }
    }

    override fun toString(): String {
        return "{hashCode=${hashCode()} limit=${limit} ${super.toString()}}"
    }
}