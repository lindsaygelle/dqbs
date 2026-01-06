package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Invocable<I : Invoker, T : Invocation> {
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    abstract fun invoke(invoker: I): T
}