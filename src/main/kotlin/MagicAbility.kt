package com.github.lindsaygelle

abstract class MagicAbility<A : MagicInvoker, B : AbilityReceiver, C : MagicContext>(limit: Int, magicPoints: Int) :
    Ability<A, B, C>(limit),
    MagicPointer {
    override var magicPoints: Int = magicPoints
        set(value) {
            field = maxOf(0, value)
            logger.trace("magicPoints={}", field)
        }

    init {
        this.magicPoints = magicPoints
    }
}