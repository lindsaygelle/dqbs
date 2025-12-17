package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class BattleTurnContext(
    battleReceiverContexts: Collection<BattleReceiverContext>,
    timeMilliseconds: Long,
    uuid: UUID,
) : TimeMeasurer,
    UniversalIdentifier {
    var battleReceiverContexts: Collection<BattleReceiverContext> = emptyList()
        set(value) {
            field = value
            logger.trace("battleReceiverContexts={}", field)
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
        this.battleReceiverContexts = battleReceiverContexts
        this.timeMilliseconds = timeMilliseconds
        this.uuid = uuid
    }
}
