package com.github.lindsaygelle

class BattleContext(
    turnContext: TurnContext,
    turns: Int
) : Context(), TurnsAccumulator {
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
