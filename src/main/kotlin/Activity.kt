package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Activity(
    appraisal: Appraisal,
    decision: Decision?,
    outcomes: List<Outcome<Check, Effect, Invocation, Reception>>?,
    ranking: Ranking?,
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

    var outcomes: List<Outcome<Check, Effect, Invocation, Reception>>? = outcomes
        set(value) {
            field = value
            logger.trace("outcomes={} outcomes.size={}", field, field?.size)
        }

    var ranking: Ranking? = ranking
        set(value) {
            field = value
            logger.trace("ranking={}", field)
        }

    init {
        this.appraisal = appraisal
        this.decision = decision
        this.outcomes = outcomes
        this.ranking = ranking
    }

    override fun toString(): String {
        return "{appraisal=${appraisal} decision=${decision} hashCode=${hashCode()} outcomes=$outcomes ranking=${ranking}}"
    }
}