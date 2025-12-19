package com.github.lindsaygelle

open class MagicContext(magicPoints: Int, name: String, timeMilliseconds: Long) :
    AbilityContext(name, timeMilliseconds),
    MagicPointer {
    override var magicPoints: Int = magicPoints
        set(value) {
            field = maxOf(0, value)
            logger.trace("magicPoints={}", field)
        }


    init {
        this.magicPoints = magicPoints
        this.timeMilliseconds = timeMilliseconds
    }
}