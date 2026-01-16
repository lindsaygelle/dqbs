package com.github.lindsaygelle.dqbs

import java.util.*

data class SleepResolutionCheck(
    val result: Boolean,
    val sleepResolution: Int,
    val sleepResolutionMaximum: Int,
    val sleepResolutionMinimum: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer