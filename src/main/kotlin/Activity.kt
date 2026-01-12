package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Activity(
    appraisal: Appraisal,
    decision: Decision?,
) {
    var appraisal: Appraisal = appraisal
        set(value) {
            field = value
            logger.trace("appraisal={}", field)
        }

    var decision: Decision? = decision
        set(value) {
            field = value
            logger.trace("decision={}", field)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    init {
        this.appraisal = appraisal
        this.decision = decision
    }

    override fun toString(): String {
        return "{appraisal=${appraisal} decision=${decision} hashCode=${hashCode()}}"
    }
}