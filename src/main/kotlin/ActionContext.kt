package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ActionContext(
    actionAssessContext: ActionAssessContext,
    actionChoiceContext: ActionChoiceContext?,
    actionWeightContext: ActionWeightContext?,
    result: Boolean,
    timeMilliseconds: Long
) : TimeMeasurer {
    var actionAssessContext: ActionAssessContext = actionAssessContext
        set(value) {
            field = value
            logger.trace("actionConditionContext={}", field)
        }
    var actionChoiceContext: ActionChoiceContext? = null
        set(value) {
            field = value
            logger.trace("actionChoiceContext={}", field)
        }
    var actionWeightContext: ActionWeightContext? = null
        set(value) {
            field = value
            logger.trace("actionWeightContext={}", field)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    var result: Boolean = false
        set(value) {
            field = value
            logger.trace("result={}", field)
        }
    override var timeMilliseconds: Long = 0L
        set(value) {
            field = maxOf(0L, value)
            logger.trace("timeMilliseconds={}", field)
        }

    init {
        this.actionAssessContext = actionAssessContext
        this.actionChoiceContext = actionChoiceContext
        this.actionWeightContext = actionWeightContext
        this.result = result
        this.timeMilliseconds = timeMilliseconds
    }
}
