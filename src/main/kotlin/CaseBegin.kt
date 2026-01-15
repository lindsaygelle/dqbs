package com.github.lindsaygelle.dqbs

import java.util.*

data class CaseBegin(
    val invokerUUID: UUID,
    val receiverCount: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : CaseTracer