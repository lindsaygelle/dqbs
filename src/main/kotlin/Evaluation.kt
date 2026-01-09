package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Evaluation(
    comparisons: List<Comparison>,
    match: Match,
    result: Boolean,
    timeMilliseconds: Long,
    uuid: UUID
) : Matcher,
    TimeMeasurer,
    UniversalIdentifier {
    var comparisons: List<Comparison> = comparisons
        set(value) {
            field = value
            logger.trace("comparisons={} comparisons.size={}", field, field.size)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    override var match: Match = match
        set(value) {
            field = value
            logger.trace("match={}", field)
        }

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
        this.comparisons = comparisons
        this.match = match
        this.result = result
        this.timeMilliseconds = timeMilliseconds
        this.uuid = uuid
    }
}