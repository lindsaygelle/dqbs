package com.github.lindsaygelle.dqbs

import java.util.*

data class AbilityEnd(
    val count: Int,
    val invokerUUID: UUID,
    override val name: String,
    val receiverCount: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : AbilityTracer