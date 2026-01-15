package com.github.lindsaygelle.dqbs

import java.util.*

data class AbilityBegin(
    override var abilityUUID: UUID,
    override var invokerUUID: UUID,
    override var limit: Int,
    override var name: String,
    override var receiverCount: Int,
    override var timeMilliseconds: Long,
    override var uuid: UUID,
) : AbilityTracer,
    Limiter,
    Namer,
    ReceiverCounter