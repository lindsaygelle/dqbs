package com.github.lindsaygelle.dqbs

import java.util.*

data class HealMoreGet(
    val healMore: Int,
    val healMoreOffset: Int,
    val healMoreScale: Int,
    val healRangeMaximum: Int,
    val healRangeMinimum: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer