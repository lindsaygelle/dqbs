package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Action(ability: Ability<AbilityInvoker, AbilityReceiver, Invocation, Reception, Check, Effect>) {
    var ability: Ability<AbilityInvoker, AbilityReceiver, Invocation, Reception, Check, Effect> = ability
        set(value) {
            field = value
            logger.trace("ability={}", field)
        }

    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    init {
        this.ability = ability
    }

    override fun toString(): String {
        return "{ability=${ability} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}