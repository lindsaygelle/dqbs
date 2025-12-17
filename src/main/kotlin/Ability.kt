package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Ability<A : AbilityInvoker, B : AbilityReceiver, C : AbilityContext> : Usable<A, B, C> {
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
}
