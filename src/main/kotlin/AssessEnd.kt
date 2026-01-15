package com.github.lindsaygelle.dqbs

import java.util.*

data class AssessEnd(
    override val invokerUUID: UUID,
    val receiverCount: Int,
    val result: Boolean,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ActionTracer