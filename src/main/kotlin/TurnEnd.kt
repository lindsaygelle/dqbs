package com.github.lindsaygelle.dqbs

import java.util.*

data class TurnEnd(
    override val timeMilliseconds: Long,
    override val turn: Int,
    override val uuid: UUID,
) : TurnTracer