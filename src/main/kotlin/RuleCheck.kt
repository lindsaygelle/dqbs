package com.github.lindsaygelle.dqbs

import java.util.*

data class RuleCheck(
    val count: Int,
    override val match: Match,
    override val receiverUUID: UUID,
    val result: Boolean,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : RuleTracer