package com.github.lindsaygelle

abstract class MagicAbility<A : MagicInvoker, B : AbilityReceiver, C : MagicContext> : Ability<A, B, C>,
    MagicPointer
