package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Weapon(name: String) : Nameable {
    @Transient
    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    override var name: String = name
        set(value) {
            field = value
            logger.trace("name={}", field)
        }

    init {
        this.name = name
    }
}