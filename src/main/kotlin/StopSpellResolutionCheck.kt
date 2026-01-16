package com.github.lindsaygelle.dqbs

import java.util.*

data class StopSpellResolutionCheck(
    val result: Boolean,
    val stopSpellResolution: Int,
    val stopSpellResolutionMaximum: Int,
    val stopSpellResolutionMinimum: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer