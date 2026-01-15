package com.github.lindsaygelle.dqbs

import java.util.*

data class MagicCostCheck(
    val magicCost: Int,
    override val name: String,
    val receiverMagicPoints: Int,
    val receiverUUID: UUID,
    val result: Boolean,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : AbilityTracer