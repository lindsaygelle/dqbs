package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Ability<A : Invoker, B : Receiver>(
    limit: Int,
) : Limiter {

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

    /*
    override fun toString(): String {
        return "checkable=${checkable} hashCode=${hashCode()} invocable=${invocable} limit=${limit} receivable=${receivable}"
    }
     */

}