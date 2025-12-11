package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Ability<A: Invoker, B: Receiver> {
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    protected fun checkInvokerHitPoints(invoker: Invoker) {
        invoker.hitPoints
    }

    protected fun checkInvokerTurnsAsleep(invoker: Invoker) {
        invoker.turnsAsleep
    }

    abstract fun use(invoker: Invoker, receiver: Receiver) : Context
}