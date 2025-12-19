package com.github.lindsaygelle

open class Resolution(resolved: Boolean) : Context() {
    var resolved: Boolean = resolved
        set(value) {
            field = value
            logger.trace("resolved={}", field)
        }

    init {
        this.resolved = resolved
        this.timeMilliseconds = System.currentTimeMillis()
    }
}
