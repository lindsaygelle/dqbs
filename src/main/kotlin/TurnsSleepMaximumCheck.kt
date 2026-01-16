package com.github.lindsaygelle.dqbs

import java.util.*

data class TurnsSleepMaximumCheck(
    val result: Boolean,
    override val timeMilliseconds: Long,
    val turnsSleep: Int,
    val turnsSleepMaximum: Int,
    override val uuid: UUID,
) : ReceiverTracer