package com.github.lindsaygelle

import java.util.*

open class MagicCheck(
    magicPoints: Int,
    magicPointsRequirement: Int,
    result: Boolean,
    timeMilliseconds: Long,
    uuid: UUID
) :
    Check(result, timeMilliseconds, uuid), MagicPointer {
    override var magicPoints: Int = magicPoints
        set(value) {
            field = value
            logger.trace("magicPoints={}", field)
        }

    var magicPointsRequirement: Int = magicPointsRequirement
        set(value) {
            field = value
            logger.trace("magicPointsRequirement={}", field)
        }

    init {
        this.magicPoints = magicPoints
        this.magicPointsRequirement = magicPointsRequirement
    }

    override fun toString(): String {
        return "magicPoints=${magicPoints} magicPointsRequirement=${magicPointsRequirement} ${super.toString()}"
    }
}