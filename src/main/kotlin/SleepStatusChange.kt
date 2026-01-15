package com.github.lindsaygelle.dqbs

import java.util.*

data class SleepStatusChange(
    val statusStopSpell: Boolean,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer