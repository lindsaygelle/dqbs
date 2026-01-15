package com.github.lindsaygelle.dqbs

import java.util.*

data class SleepResistanceGet(
    val sleepResistance: Int,
    val sleepResistanceMaximum: Int,
    val sleepResistanceMinimum: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer