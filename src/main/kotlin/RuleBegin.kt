package com.github.lindsaygelle.dqbs

import java.util.*

data class RuleBegin(
    override val match: Match,
    override val receiverUUID: UUID,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : RuleTracer