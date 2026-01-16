package com.github.lindsaygelle.dqbs

import java.util.*

data class TurnsStopSpellMinimumCheck(
    val result: Boolean,
    override val timeMilliseconds: Long,
    val turnsStopSpell: Int,
    val turnsStopSpellMinimum: Int,
    override val uuid: UUID,
) : ReceiverTracer