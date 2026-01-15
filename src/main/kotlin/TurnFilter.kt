package com.github.lindsaygelle.dqbs

import java.util.*

data class TurnFilter(
    val invokerUUID: UUID,
    val result: Boolean,
    override val timeMilliseconds: Long,
    override val turn: Int,
    override val uuid: UUID,
) : TurnTracer