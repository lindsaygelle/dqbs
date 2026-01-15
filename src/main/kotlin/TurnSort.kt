package com.github.lindsaygelle.dqbs

import java.util.*

data class TurnSort(
    val invokerUUID: UUID,
    val score: Int,
    override val timeMilliseconds: Long,
    override val turn: Int,
    override val uuid: UUID,
) : TurnTracer