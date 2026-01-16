package com.github.lindsaygelle.dqbs

import java.util.*

data class TurnSleep(
    val invokerUUID: UUID,
    override val turn: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : TurnTracer