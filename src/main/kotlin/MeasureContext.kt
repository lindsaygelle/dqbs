package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MeasureContext(
    criterionContexts: Collection<CriterionContext>,
    result: Boolean,
    timeMilliseconds: Long,
) {
    var criterionContexts: Collection<CriterionContext> = criterionContexts
        set(value) {
            field = value
            logger.trace("criterionContexts={} hashCode={}", field, hashCode())
        }

    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

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
        this.criterionContexts = criterionContexts
        this.result = result
        this.timeMilliseconds = timeMilliseconds
    }

    override fun toString(): String {
        return "{criterionContexts=${criterionContexts} result=${result} timeMilliseconds=${timeMilliseconds} hashCode=${hashCode()}}"
    }
}
