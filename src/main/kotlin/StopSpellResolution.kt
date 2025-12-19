package com.github.lindsaygelle

class StopSpellResolution(resolved: Boolean, stopSpellResolutionRandom: Int, timeMilliseconds: Long) : Resolution(
    resolved, timeMilliseconds
) {
    var stopSpellResolutionRandom: Int = stopSpellResolutionRandom
        set(value) {
            field = value
            logger.trace("stopSpellResolutionRandom={}", field)
        }

    init {
        this.stopSpellResolutionRandom = stopSpellResolutionRandom
    }
}
