package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Ranking(
    scores: List<Score>,
    timeMilliseconds: Long,
    uuid: UUID,
) : TimeMeasurer,
    UniversalIdentifier {
    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    var scores: List<Score> = scores
        set(value) {
            field = value
            logger.trace("scores={} scores.size={}", field, field.size)
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
        this.scores = scores
        this.timeMilliseconds = timeMilliseconds
        this.uuid = uuid
    }
}