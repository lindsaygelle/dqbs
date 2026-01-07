package com.github.lindsaygelle

abstract class MagicCheckable<A : MagicInvocation, B : Reception, C : MagicCheck>(magicPoints: Int) :
    Checkable<A, B, C>(),
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