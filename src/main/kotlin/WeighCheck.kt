package com.github.lindsaygelle.dqbs

import java.util.*

data class WeighCheck(
    override var receiverUUID: UUID,
    var score: Int,
    override var timeMilliseconds: Long,
    override var uuid: UUID,
    override var weighUUID: UUID,
) : ReceiverIdentifier,
    WeighTracer
