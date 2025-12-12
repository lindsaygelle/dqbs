package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

open class Actor(
    actions: List<Action>,
    agility: Int,
    allegiance: Int,
    hitPoints: Int,
    index: Int,
    turn: Int,
    uuid: UUID
) : BattleReceiver {
    override var actions: List<Action> = emptyList()
        set(value) {
            field = value.sortedBy { action -> action.priority }
            logger.trace("actions.size={}", actions.size)
        }
    override var agility: Int = 0
        set(value) {
            field = maxOf(0, value)
            logger.trace("agility={}", field)
        }
    override var allegiance: Int = 0
        set(value) {
            field = maxOf(0, value)
            logger.trace("allegiance={}", field)
        }

    override var hitPoints: Int = 0
        set(value) {
            field = maxOf(0, value)
            logger.trace("hitPoints={}", field)
        }

    override var index: Int = 0
        set(value) {
            field = maxOf(0, value)
            logger.trace("index={}", field)
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
        this.actions = actions
        this.agility = agility
        this.allegiance = allegiance
        this.hitPoints = hitPoints
        this.index = index
        this.turn = turn
        this.uuid = uuid
    }

    private fun getBattleReceiverContext(
        actionContexts: List<ActionContext>,
        timeMilliseconds: Long
    ): BattleReceiverContext {
        logger.debug("timeMilliseconds={}", timeMilliseconds)
        return BattleReceiverContext(
            actionContexts = actionContexts,
            agility = agility,
            allegiance = allegiance,
            hitPoints = hitPoints,
            index = index,
            timeMilliseconds = timeMilliseconds,
            uuid = uuid
        )
    }

    private fun processAction(
        action: Action,
        actionIndex: Int,
        battleReceivers: List<IndexedValue<BattleReceiver>>
    ): ActionContext {
        logger.debug("action={} actionIndex={} battleReceivers.size={}", action, actionIndex, battleReceivers.size)
        return action.process(this, battleReceivers)
    }

    private fun processActions(battleReceivers: List<IndexedValue<BattleReceiver>>): List<ActionContext> {
        val actionContexts = mutableListOf<ActionContext>()
        for (actionIndex in actions.indices) {
            val actionContext = processAction(actions[actionIndex], actionIndex, battleReceivers)
            actionContexts.add(actionContext)
            if (actionContext.result) {
                break
            }
        }
        return actionContexts
    }

    /*
    private fun processBattleReceiver(battleReceiver: BattleReceiver, battleReceiverIndex: Int) {
        logger.debug("battleReceiver={} battleReceiverIndex={}", battleReceiver, battleReceiverIndex)
    }

    private fun processBattleReceivers(battleReceivers: List<IndexedValue<BattleReceiver>>) {
        logger.debug("battleReceivers.size={}", battleReceivers.size)
        battleReceivers.forEach { (battleReceiverIndex, battleReceiver) ->
            processBattleReceiver(battleReceiver, battleReceiverIndex)
        }
    }
     */

    override fun takeTurn(battleReceivers: List<IndexedValue<BattleReceiver>>): BattleReceiverContext {
        logger.debug("battleReceivers.size={}", battleReceivers.size)
        val timeMilliseconds = System.currentTimeMillis()
        val actionContexts = processActions(battleReceivers)
        val battleReceiverContext = getBattleReceiverContext(actionContexts, timeMilliseconds)
        return battleReceiverContext
    }
}
