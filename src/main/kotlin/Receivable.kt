package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Receivable<T : Receiver> {
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    abstract fun receive(receiver: T): Reception
}