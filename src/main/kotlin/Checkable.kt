package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Checkable<A : Invocation, B : Reception, C : Check> {
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    abstract fun check(invocation: A, reception: B): C
}