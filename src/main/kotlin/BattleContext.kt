package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory


class BattleContext(
    battleTurnContext: BattleTurnContext,
    timeMilliseconds: Long,
    turn: Int,
) : TimeMeasurer,
    TurnAccumulator {
    var battleTurnContext: BattleTurnContext = battleTurnContext
        set(value) {
            field = value
            logger.trace("battleTurnContext={}", field)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    override var timeMilliseconds: Long = 0L
        set(value) {
            field = maxOf(0L, value)
            logger.trace("timeMilliseconds={}", field)
        }
    override var turn: Int = 0
        set(value) {
            field = maxOf(0, value)
            logger.trace("turn={}", field)
        }

    init {
        this.battleTurnContext = battleTurnContext
        this.timeMilliseconds = timeMilliseconds
        this.turn = turn
    }
}
