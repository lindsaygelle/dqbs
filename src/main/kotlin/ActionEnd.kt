package com.github.lindsaygelle.dqbs

import java.util.*

data class ActionEnd(
    override val invokerUUID: UUID,
    val result: Boolean,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ActionTracer