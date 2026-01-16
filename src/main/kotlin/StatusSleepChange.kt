package com.github.lindsaygelle.dqbs

import java.util.*

data class StatusSleepChange(
    val statusSleep: Boolean,
    val statusSleepPrevious: Boolean,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer