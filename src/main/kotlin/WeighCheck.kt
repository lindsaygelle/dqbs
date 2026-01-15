package com.github.lindsaygelle.dqbs

import java.util.*

data class WeighCheck(
    val receiverUUID: UUID,
    val score: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : WeighTracer