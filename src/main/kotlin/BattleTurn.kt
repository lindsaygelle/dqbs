package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class BattleTurn(
    battleReceivers: List<IndexedValue<BattleReceiver>>,
    turn: Int,
) : TurnAccumulator,
    UniversalIdentifier {
    private var battleReceivers: List<IndexedValue<BattleReceiver>> = emptyList()
        set(value) {
            field = value
            logger.trace("battleReceivers={}", field)
        }
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    override var turn: Int = 0
        set(value) {
            field = maxOf(0, value)
            logger.trace("turn={}", field)
        }
    override var uuid: UUID = UUID(0L, 0L)
        set(value) {
            field = value
            logger.trace("uuid={}", field)
        }

    init {
        this.battleReceivers = battleReceivers
        this.turn = turn
    }

    private fun getBattleReceiverContext(
        battleReceiver: BattleReceiver,
        battleReceivers: List<IndexedValue<BattleReceiver>>,
    ): BattleReceiverContext {
        logger.debug("battleReceiver={} battleReceivers.size={}", battleReceiver, battleReceivers.size)
        return battleReceiver.takeTurn(battleReceivers)
    }

    private fun getBattleReceiverContexts(
        battleReceiverIterator: Iterator<IndexedValue<BattleReceiver>>,
        battleReceivers: List<IndexedValue<BattleReceiver>>,
    ): List<BattleReceiverContext> {
        val battleReceiverContexts = mutableListOf<BattleReceiverContext>()
        while (battleReceiverIterator.hasNext()) {
            logger.debug("battleReceiverIterator.hasNext={}", battleReceiverIterator.hasNext())
            val (battleReceiverIndex, battleReceiver) = battleReceiverIterator.next()
            val battleReceiverContext = processBattleReceiver(battleReceiver, battleReceiverIndex, battleReceivers)
            battleReceiverContexts.add(battleReceiverContext)
        }
        return battleReceiverContexts
    }

    private fun getBattleTurnContext(
        battleReceiverContexts: List<BattleReceiverContext>,
        timeMilliseconds: Long,
    ): BattleTurnContext {
        logger.debug(
            "battleReceiverContexts.size={} timeMilliseconds={}", battleReceiverContexts.size, timeMilliseconds
        )
        return BattleTurnContext(
            battleReceiverContexts = battleReceiverContexts, timeMilliseconds = timeMilliseconds, uuid = uuid
        )
    }

    fun process(): BattleTurnContext {
        val timeMilliseconds = System.currentTimeMillis()
        val battleReceiverContexts = processBattleReceivers(battleReceivers)
        val battleTurnContext = getBattleTurnContext(battleReceiverContexts, timeMilliseconds)
        return battleTurnContext
    }

    private fun processBattleReceiver(
        battleReceiver: BattleReceiver,
        battleReceiverIndex: Int,
        battleReceivers: List<IndexedValue<BattleReceiver>>,
    ): BattleReceiverContext {
        logger.debug(
            "battleReceiver={} battleReceiverIndex={} battleReceivers.size={}",
            battleReceiver,
            battleReceiverIndex,
            battleReceivers.size
        )
        battleReceiver.index = battleReceiverIndex
        battleReceiver.turn = turn
        return getBattleReceiverContext(battleReceiver, battleReceivers)
    }

    private fun processBattleReceivers(battleReceivers: List<IndexedValue<BattleReceiver>>): List<BattleReceiverContext> {
        logger.debug("battleReceivers.size={}", battleReceivers.size)
        val battleReceiverIterator = battleReceivers.iterator()
        return getBattleReceiverContexts(battleReceiverIterator, battleReceivers)
    }
}
