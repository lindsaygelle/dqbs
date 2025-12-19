package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

open class Context(timeMilliseconds: Long = System.currentTimeMillis()) : TimeMeasurer {
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    final override var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = maxOf(0, value)
            logger.trace("timeMilliseconds={}", field)
        }

    init {
        this.timeMilliseconds = timeMilliseconds
    }
}
