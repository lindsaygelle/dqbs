package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Turn(battlers: List<Battler>) : Ticker<TurnContext> {
    var battlers: List<Battler> = battlers
        set(value) {
            field = value
            logger.trace("battlers={}", field)
        }
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    init {
        this.battlers = battlers
    }

    private fun getBattlerContext(battler: Battler, battlers: List<Battler>): BattlerContext {
        return battler.turn(battlers)
    }

    private fun getBattlerContexts(battlerIterator: Iterator<Battler>, battlers: List<Battler>): List<BattlerContext> {
        val battlerContexts = mutableListOf<BattlerContext>()
        while (battlerIterator.hasNext()) {
            battlerContexts.add(getBattlerContext(battlerIterator.next(), battlers))
        }
        return battlerContexts
    }

    private fun getBattlerIterator(battlers: List<Battler>): Iterator<Battler> {
        return battlers.iterator()
    }

    override fun tick(): TurnContext {
        val battlerIterator = getBattlerIterator(battlers)
        val battlerContexts = getBattlerContexts(battlerIterator, battlers)
        return TurnContext(battlerContexts, System.currentTimeMillis())
    }
}
