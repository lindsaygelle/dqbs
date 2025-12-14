package com.github.lindsaygelle

abstract class Ability<A : AbilityInvoker, B : AbilityReceiver> {
    abstract fun use(abilityInvoker: A, abilityReceiver: B): AbilityContext
}