package com.github.lindsaygelle

abstract class Ability<A : AbilityInvoker, B : AbilityReceiver, C : AbilityContext> : Usable<A, B, C>
