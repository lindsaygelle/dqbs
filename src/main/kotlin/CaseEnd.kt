package com.github.lindsaygelle.dqbs

import java.util.*

data class CaseEnd(
    val invokerUUID: UUID,
    val receiverCount: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : CaseTracer