package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TurnContext(battlerContexts: List<BattlerContext>, timeMilliseconds: Long) : Context {
    var battlerContexts: List<BattlerContext> = battlerContexts
        set(value) {
            field = value
            logger.trace("battlerContexts={} battlerContexts.size={}", field, field.size)
        }

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    override var timeMilliseconds: Long = timeMilliseconds
        set(value) {
            field = maxOf(0, value)
            logger.trace("timeMilliseconds={}}", field)
        }

    init {
        this.battlerContexts = battlerContexts
        this.timeMilliseconds = timeMilliseconds
    }
}
