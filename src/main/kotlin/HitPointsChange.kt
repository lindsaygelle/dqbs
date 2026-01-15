package com.github.lindsaygelle.dqbs

import java.util.*

data class HitPointsChange(
    val hitPoints: Int,
    val hitPointsPrevious: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer