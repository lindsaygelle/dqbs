package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

open class Invocation(timeMilliseconds: Long, uuid: UUID) : TimeMeasurer,
    UniversalIdentifier {
    @Transient
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    override var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = maxOf(0, value)
            logger.trace("timeMilliseconds={}", field)
        }

    override var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={}", field)
        }

    init {
        this.timeMilliseconds = timeMilliseconds
        this.uuid = uuid
    }

    override fun toString(): String {
        return "{hashCode=${hashCode()} timeMilliseconds=${timeMilliseconds} uuid=${uuid}}"
    }
}