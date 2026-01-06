package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

open class Outcome(
    check: Check,
    invocation: Invocation,
    reception: Reception,
    timeMilliseconds: Long,
    uuid: UUID
) : TimeMeasurer,
    UniversalIdentifier {
    var check: Check = check
        set(value) {
            field = value
            logger.trace("check={}", field)
        }
    var invocation: Invocation = invocation
        set(value) {
            field = value
            logger.trace("invocation={}", field)
        }

    @Transient
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    var reception: Reception = reception
        set(value) {
            field = value
            logger.trace("reception={}", field)
        }
    override var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = value
            logger.trace("timeMilliseconds={}", field)
        }
    override var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={}", field)
        }

    init {
        this.check = check
        this.invocation = invocation
        this.reception = reception
        this.timeMilliseconds = timeMilliseconds
        this.uuid = uuid
    }

    override fun toString(): String {
        return "check=${check} hashCode=${hashCode()} invocation=${invocation} reception=${reception} timeMilliseconds=${timeMilliseconds} uuid=${uuid}"
    }
}