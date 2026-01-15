package com.github.lindsaygelle.dqbs

import java.util.*

data class QualifyBegin(
    override val invokerUUID: UUID,
    override val receiverCount: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : QualifyTracer
