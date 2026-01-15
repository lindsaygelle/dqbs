package com.github.lindsaygelle.dqbs

import java.util.*

data class StopSpellResistanceGet(
    val stopSpellResistanceMaximum: Int,
    val stopSpellResistanceMinimum: Int,
    val stopSpellResistance: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer