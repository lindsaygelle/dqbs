package com.github.lindsaygelle.dqbs

import java.util.*

data class StatusSleepCheck(
    val result: Boolean,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer