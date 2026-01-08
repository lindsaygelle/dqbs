package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Correlation(
    criteria: List<Criterion>,
    match: Match
) {
    private var criteria: List<Criterion> = criteria
        set(value) {
            field = value
            logger.trace("criteria={} criteria.size={}", field, field.size)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    private var match: Match = match
        set(value) {
            field = value
            logger.trace("match={}", field)
        }

    init {
        this.criteria = criteria
        this.match = match
    }
}