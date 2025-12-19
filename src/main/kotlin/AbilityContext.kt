package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

open class AbilityContext(name: String, timeMilliseconds: Long) : Context,
    Nameable {
    @Transient
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    override var name: String = name
        set(value) {
            field = value
            logger.trace("name={}", field)
        }
    override var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = maxOf(0, value)
            logger.trace("timeMilliseconds={}", field)
        }

    init {
        this.name = name
        this.timeMilliseconds = timeMilliseconds
    }
}
