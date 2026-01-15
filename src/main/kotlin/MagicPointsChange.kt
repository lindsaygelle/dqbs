package com.github.lindsaygelle.dqbs

import java.util.*

data class MagicPointsChange(
    val magicPoints: Int,
    val magicPointsPrevious: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer