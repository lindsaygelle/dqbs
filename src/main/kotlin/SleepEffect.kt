package com.github.lindsaygelle

import java.util.*

class SleepEffect(statusSleep: Boolean, timeMilliseconds: Long, uuid: UUID) : Effect(timeMilliseconds, uuid),
    SleepToggler {
    override var statusSleep: Boolean = statusSleep
        set(value) {
            field = value
            logger.trace("statusSleep={}", field)
        }

    init {
        this.statusSleep = statusSleep
    }

    override fun toString(): String {
        return "{statusSleep=${statusSleep} ${super.toString()}}"
    }
}