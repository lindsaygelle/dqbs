package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Battle(battlers: List<Battler>, uuid: UUID) : Ticker<BattleContext>,
    TurnsAccumulator,
    UniversalIdentifier {
    var battlers: List<Battler> = battlers
        set(value) {
            field = value
            logger.trace("battlers={} battlers.size={}", field, field.size)
        }
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    override var turns: Int = 0
        set(value) {
            field = maxOf(0, value)
            logger.trace("turns={}", field)
        }
    override var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={}", field)
        }

    init {
        this.battlers = battlers
        this.turns = 0
        this.uuid = uuid
    }

    private fun getBattleContext(turnContext: TurnContext): BattleContext {
        logger.debug("turnContext={}", turnContext)
        return BattleContext(System.currentTimeMillis(), turnContext, turns)
    }

    private fun getBattlers(battlers: List<Battler>): List<Battler> {
        logger.debug("battlers={} battlers.size={}", battlers, battlers.size)
        return sortBattlers(filterBattlers(battlers))
    }

    private fun getTurn(battlers: List<Battler>): Turn {
        logger.debug("battlers={} battlers.size={}", battlers, battlers.size)
        return Turn(getBattlers(battlers))
    }

    private fun getTurnContext(turn: Turn): TurnContext {
        logger.debug("turn={}", turn)
        return turn.tick()
    }

    private fun filterBattler(battler: Battler): Boolean {
        logger.debug(
            "battler.hitPoints={} battler.actions.size={} battler.uuid={}",
            battler.hitPoints,
            battler.actions.size,
            battler.uuid
        )
        return (battler.hitPoints > 0) && battler.actions.isNotEmpty()
    }

    private fun filterBattlers(battlers: List<Battler>): List<Battler> {
        logger.debug("battlers={} battlers.size={}", battlers, battlers.size)
        return battlers.filter { battler ->
            filterBattler(battler)
        }
    }

    private fun sortBattler(battler: Battler): Int {
        logger.debug("battler.agility={} battler.uuid={}", battler.agility, battler.uuid)
        return battler.agility
    }

    private fun sortBattlers(battlers: List<Battler>): List<Battler> {
        logger.debug("battlers={} battlers.size={}", battlers, battlers.size)
        return battlers.sortedBy { battler ->
            sortBattler(battler)
        }
    }

    override fun tick(): BattleContext {
        val turn = getTurn(battlers)
        val turnContext = getTurnContext(turn)
        return getBattleContext(turnContext)
    }
}
