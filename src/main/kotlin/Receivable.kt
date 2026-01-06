package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Receivable<R : Receiver, T : Reception> {
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    abstract fun receive(receiver: R): T
}