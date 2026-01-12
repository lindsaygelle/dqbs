package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.UUID

open class Consideration(assessments: List<Assessment>, result: Boolean, timeMilliseconds: Long, uuid: UUID) : TimeMeasurer,
    UniversalIdentifier {
    var assessments: List<Assessment> = assessments
        set(value) {
            field = value
            logger.trace("assessment={} assessments.size={}", field, field.size)
        }

    @Transient
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    var result: Boolean = result
        set(value) {
            field = value
            logger.trace("result={}", field)
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
        this.assessments = assessments
        this.result = result
        this.timeMilliseconds = timeMilliseconds
        this.uuid = uuid
    }
}