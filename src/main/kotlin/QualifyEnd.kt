package com.github.lindsaygelle.dqbs

import java.util.*

data class QualifyEnd(
    val count: Int,
    override val invokerUUID: UUID,
    override val receiverCount: Int,
    val result: Boolean,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : QualifyTracer