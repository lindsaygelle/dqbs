package com.github.lindsaygelle.dqbs

import java.util.*

data class HealGet(
    val heal: Int,
    val healOffset: Int,
    val healRangeMaximum: Int,
    val healRangeMinimum: Int,
    val healScale: Int,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : ReceiverTracer