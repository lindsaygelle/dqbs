package com.github.lindsaygelle

abstract class ItemAbility<A : ItemInvoker, B : AbilityReceiver, C : ItemContext> : Ability<A, B, C>(),
    Itemizer
}