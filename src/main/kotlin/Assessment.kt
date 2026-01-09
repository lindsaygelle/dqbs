package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Assessment(evaluations: List<Evaluation>, result: Boolean, timeMilliseconds: Long, uuid: UUID) : TimeMeasurer,
    UniversalIdentifier {
    var evaluations: List<Evaluation> = evaluations
        set(value) {
            field = value
            logger.trace("evaluations={} evaluations.size={}", field, field.size)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

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
        this.evaluations = evaluations
        this.result = result
        this.timeMilliseconds = timeMilliseconds
        this.uuid = uuid
    }
}