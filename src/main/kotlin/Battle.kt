package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Battle(battlers: List<Battler>, uuid: UUID) : Iterator<BattleContext>,
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

    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): BattleContext {
        TODO("Not yet implemented")
    }
}
