package com.github.lindsaygelle.dqbs

import java.util.*

data class WeighEnd(
    val receiverCount: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : WeighTracer