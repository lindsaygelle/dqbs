package com.github.lindsaygelle.dqbs

import java.util.*

data class TurnsStopSpellChange(
    val turnsStopSpell: Int,
    val turnsStopSpellPrevious: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer