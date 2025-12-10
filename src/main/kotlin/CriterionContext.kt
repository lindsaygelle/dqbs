package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class CriterionContext(
    comparisonContexts: Collection<ComparisonContext>,
    match: Match,
    result: Boolean,
    timeMilliseconds: Long,
) {
    var comparisonContexts: Collection<ComparisonContext> = comparisonContexts
        set(value) {
            field = value
            logger.trace("comparisonContexts={} hashCode={}", field, hashCode())
        }

    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    var match: Match = match
        set(value) {
            field = value
            logger.trace("match={} hashCode={}", field, hashCode())
        }

    var result: Boolean = result
        set(value) {
            field = value
            logger.trace("result={} hashCode={}", field, hashCode())
        }

    var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = value
            logger.trace("timeMilliseconds={} hashCode={}", field, hashCode())
        }

    init {
        this.comparisonContexts = comparisonContexts
        this.match = match
        this.result = result
        this.timeMilliseconds = timeMilliseconds
    }

    override fun toString(): String {
        return "{comparisonContexts=${comparisonContexts} match=${match} result=${result} timeMilliseconds=${timeMilliseconds} hashCode=${hashCode()}}"
    }
}
