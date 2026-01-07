package com.github.lindsaygelle

abstract class MagicAbility<A : MagicInvoker, B : AbilityReceiver, I : MagicInvocation, R : Reception, C : Check, E : Effect>(
    limit: Int,
    magicPoints: Int,
) : Ability<A, B, I, R, C, E>(limit),
    MagicPointer {
    override var magicPoints: Int = magicPoints
        set(value) {
            field = maxOf(0, value)
            logger.trace("magicPoints={}", field)
        }

    init {
        this.magicPoints = magicPoints
    }

    override fun toString(): String {
        return "{magicPoints=${magicPoints} ${this.javaClass.superclass.simpleName}=${super.toString()}}"
    }
}