package com.github.lindsaygelle.dqbs

import java.util.*

data class TurnsSleepMinimumCheck(
    val result: Boolean,
    override val timeMilliseconds: Long,
    val turnsSleep: Int,
    val turnsSleepMinimum: Int,
    override val uuid: UUID,
) : ReceiverTracer