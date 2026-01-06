package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Ability<A : Invoker, B : Receiver>(limit: Int) : Limiter {
    final override var limit: Int = limit
        set(value) {
            field = maxOf(0, value)
            logger.trace("limit={}", field)
        }

    @Transient
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    init {
        this.limit = limit
    }
    
    protected abstract fun checkInvoker(invoker: A)
    
    protected abstract fun checkReceiver(receiver: B)

    override fun toString(): String {
        return "hashCode=${hashCode()} limit=${limit}"
    }

    fun use(invoker: A, receivers: List<B>) {
        receivers.take(limit).forEachIndexed { _, receiver ->
            checkInvoker(invoker)
            checkReceiver(receiver)
        }
    }
}
