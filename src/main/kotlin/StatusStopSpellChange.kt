package com.github.lindsaygelle.dqbs

import java.util.*

data class StatusStopSpellChange(
    val statusStopSpell: Boolean,
    val statusStopSpellPrevious: Boolean,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer