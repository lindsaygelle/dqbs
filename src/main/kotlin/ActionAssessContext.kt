package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ActionAssessContext(result: Boolean, timeMilliseconds: Long) : TimeMeasurer {
    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    var result: Boolean = false
        set(value) {
            field = value
            logger.trace("result={}", field)
        }
    override var timeMilliseconds: Long = 0L
        set(value) {
            field = maxOf(0L, value)
            logger.trace("timeMilliseconds={}", field)
        }

    init {
        this.result = result
        this.timeMilliseconds = timeMilliseconds
    }
}
