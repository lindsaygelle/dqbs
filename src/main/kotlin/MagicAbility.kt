package com.github.lindsaygelle

abstract class MagicAbility<A : MagicInvoker, B : AbilityReceiver, C : MagicContext>(magicPoints: Int) : Ability<A, B, C>(),
    MagicPointer {
    override var magicPoints: Int = magicPoints
        set(value) {
            field = maxOf(0, value)
            logger
        }

    init {
        this.magicPoints = magicPoints
    }
}