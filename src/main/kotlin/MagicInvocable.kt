package com.github.lindsaygelle

abstract class MagicInvocable<I : MagicInvoker, T : Invocation>(magicPoints: Int) : Invocable<I, T>(),
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
        return "{magicPoints=${magicPoints} ${super.toString()}}"
    }
}