package com.github.lindsaygelle

open class MagicInvocation(magicPoints: Int) : Invocation(), MagicPointer {
    override var magicPoints: Int = magicPoints
        set(value) {
            field = value
            logger.trace("magicPoints={}", field)
        }

    init {
        this.magicPoints = magicPoints
    }

    override fun toString(): String {
        return "magicPoints=${magicPoints} ${super.toString()}"
    }
}