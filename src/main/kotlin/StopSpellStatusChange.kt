package com.github.lindsaygelle.dqbs

import java.util.*

data class StopSpellStatusChange(
    val statusStopSpell: Boolean,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer