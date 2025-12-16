package com.github.lindsaygelle

interface Ability<A : AbilityInvoker, B : AbilityReceiver, C : AbilityContext> : Usable<A, B, C>