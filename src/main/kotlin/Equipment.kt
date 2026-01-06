package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

open class Equipment(name: String, uuid: UUID) : Nameable,
    UniversalIdentifier {

    @Transient
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    override var name: String = name
        set(value) {
            field = value
            logger.trace("name={}", field)
        }
    override var uuid: UUID = uuid
        set(value) {
            field = value
            logger.trace("uuid={}", field)
        }

    init {
        this.name = name
        this.uuid = uuid
    }

    override fun toString(): String {
        return "name=${name} uuid=${uuid}"
    }
}