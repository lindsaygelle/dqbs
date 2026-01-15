package com.github.lindsaygelle.dqbs

import java.util.*

data class StatusStopSpellCheck(
    override val name: String,
    val receiverUUID: UUID,
    val result: Boolean,
    val statusStopSpell: Boolean,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : AbilityTracer