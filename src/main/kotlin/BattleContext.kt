package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class BattleContext(
    timeMilliseconds: Long,
    turnContext: TurnContext,
    turns: Int
) : Context, TurnsAccumulator {
    var turnContext: TurnContext = turnContext
        set(value) {
            field = value
            logger.trace("turnContext={}", field)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    override var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = maxOf(0L, value)
            logger.trace("timeMilliseconds={}", field)
        }
    override var turns: Int = turns
        set(value) {
            field = maxOf(0, value)
            logger.trace("turns={}", field)
        }

    init {
        this.timeMilliseconds = timeMilliseconds
        this.turnContext = turnContext
        this.turns = turns
    }
}
