package com.github.lindsaygelle.dqbs

import java.util.*

data class TurnsStopSpellMaximumCheck(
    val result: Boolean,
    override val timeMilliseconds: Long,
    val turnsStopSpell: Int,
    val turnsStopSpellMaximum: Int,
    override val uuid: UUID,
) : ReceiverTracer