package com.github.lindsaygelle

abstract class MagicAbility<A : MagicInvoker, B : AbilityReceiver, C : MagicContext>(magicPoints: Int) : Ability<A, B, C>,
    MagicPointer
