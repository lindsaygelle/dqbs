package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Battle(battlers: List<Battler>, timeMilliseconds: Long, uuid: UUID) : TimeMeasurer,
    TurnsAccumulator,
    UniversalIdentifier {
    var battlers: List<Battler> = battlers
        set(value) {
            field = value.distinctBy { battler -> battler.hashCode() }
            logger.trace("battlers={} battlers.size={}", field, field.size)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    override var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = maxOf(0, value)
            logger.trace("timeMilliseconds={}", field)
        }

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
        this.timeMilliseconds = timeMilliseconds
        this.turns = turns
        this.uuid = uuid
    }

    fun tick() {
        tickBattlers(battlers.filter { battler -> battler.hitPoints > 0 }
            .sortedByDescending { battler -> battler.agility })
    }

    private fun tickBattler(battler: Battler, battlerIndex: Int, battlers: List<Battler>) {
        battler.act(battlers)
    }

    private fun tickBattlers(battlers: List<Battler>) {
        val battlerIterator = battlers.withIndex().iterator()
        while (battlerIterator.hasNext()) {
            val (battlerIndex, battler) = battlerIterator.next()
            tickBattler(battler, battlerIndex, battlers)
        }
    }
}