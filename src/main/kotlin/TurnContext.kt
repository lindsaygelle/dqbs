package com.github.lindsaygelle

class TurnContext(battlerContexts: List<BattlerContext>) : Context() {
    var battlerContexts: List<BattlerContext> = battlerContexts
        set(value) {
            field = value
            logger.trace("battlerContexts={} battlerContexts.size={}", field, field.size)
        }

    init {
        this.battlerContexts = battlerContexts
    }
}
