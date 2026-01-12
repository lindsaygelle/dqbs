package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

open class Evaluatable(
    evaluations: List<Evaluation>, receiverUUID: UUID, timeMilliseconds: Long, uuid: UUID,
) : TimeMeasurer,
    UniversalIdentifier {
    var evaluations: List<Evaluation> = evaluations
        set(value) {
            field = value
            logger.trace("evaluations={} evaluations.size={}", field, field.size)
        }

    @Transient
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    var receiverUUID: UUID = receiverUUID
        set(value) {
            field = value
            logger.trace("receiverUUID={}", field)
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
        this.receiverUUID = receiverUUID
        this.timeMilliseconds = timeMilliseconds
        this.uuid = uuid
    }
}