package com.github.lindsaygelle.dqbs

import java.util.*

data class TurnFilter(
    override var battleUUID: UUID,
    override var invokerUUID: UUID,
    var result: Boolean,
    override var timeMilliseconds: Long,
    override var turn: Int,
    override var uuid: UUID,
) : InvokerIdentifier,
    TurnTracer