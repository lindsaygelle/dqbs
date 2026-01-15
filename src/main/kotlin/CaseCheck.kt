package com.github.lindsaygelle.dqbs

import java.util.*

data class CaseCheck(
    val count: Int,
    val invokerUUID: UUID,
    val receiverUUID: UUID,
    val result: Boolean,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : CaseTracer