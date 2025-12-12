package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class BattleReceiverContext(
    actionContexts: List<ActionContext>,
    agility: Int,
    allegiance: Int,
    hitPoints: Int,
    index: Int,
    timeMilliseconds: Long,
    uuid: UUID
) : AgilityPointer, AllegianceKeeper, HitPointer, Indexer, TimeMeasurer, UniversalIdentifier {
    var actionContexts: Collection<ActionContext> = emptyList()
        set(value) {
            field = value
            logger.trace("actionContexts={}", field)
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

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    override var timeMilliseconds: Long = 0L
        set(value) {
            field = maxOf(0L, value)
            logger.trace("timeMilliseconds={}", field)
        }
    override var uuid: UUID = UUID(0L, 0L)
        set(value) {
            field = value
            logger.trace("uuid={}", field)
        }

    init {
        this.actionContexts = actionContexts
        this.agility = agility
        this.allegiance = allegiance
        this.hitPoints = hitPoints
        this.index = index
        this.timeMilliseconds = timeMilliseconds
        this.uuid = uuid
    }
}
