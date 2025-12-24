package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

open class Resolution(resolved: Boolean, timeMilliseconds: Long) : TimeMeasurer {
    @Transient
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    var resolved: Boolean = resolved
        set(value) {
            field = value
            logger.trace("resolved={}", field)
        }
    final override var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = value
            logger.trace("timeMilliseconds={}", field)
        }

    init {
        this.resolved = resolved
        this.timeMilliseconds = timeMilliseconds
    }
}