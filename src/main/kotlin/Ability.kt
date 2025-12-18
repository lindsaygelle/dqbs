package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Ability<A : AbilityInvoker, B : AbilityReceiver, C : AbilityContext>(limit: Int) : Usable<A, B, C>,
    Limiter {
    override var limit: Int = limit
        set(value) {
            field = maxOf(1, value)
            logger.trace("limit={}", field)
        }
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    init {
        this.limit = limit
    }

    override fun use(invoker: A, receivers: List<B>): C {
        logger.debug("invoker={} limit={} receivers={} receivers.size={}", invoker, limit, receivers, receivers.size)
        TODO()
    }
}
