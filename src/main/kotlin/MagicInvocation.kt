package com.github.lindsaygelle

import java.util.*

open class MagicInvocation(magicPoints: Int, timeMilliseconds: Long, uuid: UUID) : Invocation(timeMilliseconds, uuid),
    MagicPointer {
    override var magicPoints: Int = magicPoints
        set(value) {
            field = value
            logger.trace("magicPoints={}", field)
        }

    init {
        this.magicPoints = magicPoints
    }

    override fun toString(): String {
        return "{magicPoints=${magicPoints} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}