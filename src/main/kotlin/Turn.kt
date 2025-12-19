package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class Turn(uuid: UUID = UUID.randomUUID()) : UniversalIdentifier {
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    override var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={}", field)
        }

    init {
        this.uuid = uuid
    }
}