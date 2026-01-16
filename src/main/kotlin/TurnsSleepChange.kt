package com.github.lindsaygelle.dqbs

import java.util.*

data class TurnsSleepChange(
    val turnsSleep: Int,
    val turnsSleepPrevious: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer