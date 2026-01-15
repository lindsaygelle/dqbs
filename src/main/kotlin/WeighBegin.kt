package com.github.lindsaygelle.dqbs

import java.util.*

data class WeighBegin(
    override var receiverCount: Int,
    override var timeMilliseconds: Long,
    override var uuid: UUID,
    override var weighUUID: UUID,
) : ReceiverCounter,
    WeighTracer