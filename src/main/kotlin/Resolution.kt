package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

open class Resolution(resolved: Boolean, timeMilliseconds: Long, uuid: UUID) : TimeMeasurer,
    UniversalIdentifier {
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

    final override var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={}", field)
        }

    init {
        this.resolved = resolved
        this.timeMilliseconds = timeMilliseconds
        this.uuid = uuid
    }

    override fun toString(): String {
        return "{hashCode=${hashCode()} resolved=${resolved} timeMilliseconds=${timeMilliseconds} uuid=${uuid}}"
    }
}