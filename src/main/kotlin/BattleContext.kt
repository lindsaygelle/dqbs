package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class BattleContext(
    override var timeMilliseconds: Long,
    turnContext: TurnContext,
    turns: Int
) : Context, TurnsAccumulator {
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    var turnContext: TurnContext = turnContext
        set(value) {
            field = value
            logger.trace("turnContext={}", field)
        }

    override var turns: Int = turns
        set(value) {
            field = maxOf(0, value)
            logger.trace("turns={}", field)
        }

    init {
        this.turnContext = turnContext
        this.turns = turns
    }
}
