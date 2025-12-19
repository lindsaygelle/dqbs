package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Resolvable<R : Resolver, T : Resolution>(protected val resolver: R) {
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
    abstract fun resolve(): T
}
