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

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    init {
        this.appraisal = appraisal
    }
}