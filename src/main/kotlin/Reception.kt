package com.github.lindsaygelle

import org.slf4j.Logger
import org.slf4j.LoggerFactory

open class Reception {
    @Transient
    protected val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)
}
