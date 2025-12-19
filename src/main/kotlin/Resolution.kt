package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

open class Resolution(resolved: Boolean) : TimeMeasurer {
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    var resolved: Boolean = resolved
        set(value) {
            field = value
            logger.trace("resolved={}", field)
        }
    override var timeMilliseconds: Long = 0L
        set(value) {
            field = value
            logger.trace("timeMilliseconds={}", field)
        }

    init {
        this.resolved = resolved
        this.timeMilliseconds = System.currentTimeMillis()
    }
}
