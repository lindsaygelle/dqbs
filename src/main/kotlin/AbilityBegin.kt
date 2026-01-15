package com.github.lindsaygelle.dqbs

import java.util.*

data class AbilityBegin(
    val invokerUUID: UUID,
    val limit: Int,
    override val name: String,
    val receiverCount: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : AbilityTracer