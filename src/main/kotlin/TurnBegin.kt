package com.github.lindsaygelle.dqbs

import java.util.*

data class TurnBegin(
    val invokerCount: Int,
    override val timeMilliseconds: Long,
    override val turn: Int,
    override val uuid: UUID,
) : TurnTracer