package com.github.lindsaygelle.dqbs

import java.util.UUID

data class TurnBegin(
    override var battleUUID: UUID,
    override var invokerCount: Int,
    override var timeMilliseconds: Long,
    override var turn: Int,
    override var uuid: UUID,
) : InvokerCounter,
    TurnTracer
