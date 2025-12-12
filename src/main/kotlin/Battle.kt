package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Battle(
    battleReceivers: List<BattleReceiver>,
    uuid: UUID
) : Iterator<BattleContext>, TurnAccumulator, UniversalIdentifier {
    private var battleReceivers: List<BattleReceiver> = emptyList()
        set(value) {
            field = value
            logger.trace("battleReceivers={} battleReceivers.size={}", field, field.size)
        }
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    override var turn: Int = 0
        set(value) {
            field = maxOf(0, value)
            logger.trace("turn={}", field)
        }
    override var uuid: UUID = UUID(0, 0)
        set(value) {
            field = value
            logger.trace("uuid={}", field)
        }

    init {
        this.battleReceivers = battleReceivers
        this.uuid = uuid
    }

    private fun filterBattleReceiver(battleReceiver: BattleReceiver, battleReceiverIndex: Int): Boolean {
        logger.debug(
            "battleReceiver.hashCode={} battleReceiver.hitPoints={} battleReceiver.index={} battleReceiver.uuid={} battleReceiverIndex={}",
            battleReceiver.hashCode(),
            battleReceiver.hitPoints,
            battleReceiver.index,
            battleReceiver.uuid,
            battleReceiverIndex
        )
        return battleReceiver.hitPoints > 0
    }

    private fun filterBattleReceivers(battleReceivers: List<BattleReceiver>): List<BattleReceiver> {
        logger.debug("battleReceivers.size={}", battleReceivers.size)
        return battleReceivers.filterIndexed { battleReceiverIndex, battleReceiver ->
            filterBattleReceiver(
                battleReceiver,
                battleReceiverIndex
            )
        }
    }

    private fun getBattleContext(battleTurnContext: BattleTurnContext, timeMilliseconds: Long): BattleContext {
        logger.debug("battleTurnContext={} timeMilliseconds={}", battleTurnContext, timeMilliseconds)
        return BattleContext(
            battleTurnContext = battleTurnContext,
            timeMilliseconds = timeMilliseconds,
            turn = turn,
        )
    }

    private fun getBattleTurn(): BattleTurn {
        val battleReceivers = sortBattleReceivers(filterBattleReceivers(battleReceivers))
        val battleTurn = BattleTurn(
            battleReceivers = battleReceivers, turn = turn
        )
        return battleTurn
    }

    private fun getBattleTurnContext(battleTurn: BattleTurn): BattleTurnContext {
        logger.debug("battleTurn={}", battleTurn)
        return battleTurn.process()
    }

    override fun hasNext(): Boolean {
        return battleReceivers.distinctBy { battleReceiver -> battleReceiver.allegiance }.size > 1
    }

    override fun next(): BattleContext {
        val timeMilliseconds = System.currentTimeMillis()
        val battleTurn = getBattleTurn()
        val battleTurnContext = getBattleTurnContext(battleTurn)
        val battleContext = getBattleContext(battleTurnContext, timeMilliseconds)
        turn++
        return battleContext
    }

    private fun sortBattleReceiver(battleReceiver: BattleReceiver, battleReceiverIndex: Int): Int {
        logger.debug(
            "battleReceiver.agility={} battleReceiver.hashCode={} battleReceiver.index={} battleReceiver.uuid={} battleReceiverIndex={}",
            battleReceiver.agility,
            battleReceiver.hashCode(),
            battleReceiver.index,
            battleReceiver.uuid,
            battleReceiverIndex
        )
        return battleReceiver.agility
    }

    private fun sortBattleReceivers(battleReceivers: List<BattleReceiver>): List<IndexedValue<BattleReceiver>> {
        logger.debug("battleReceivers.size={}", battleReceivers.size)
        return battleReceivers.withIndex()
            .sortedBy { indexedValue ->
                sortBattleReceiver(
                    battleReceiver = indexedValue.value,
                    battleReceiverIndex = indexedValue.index
                )
            }
    }

}
