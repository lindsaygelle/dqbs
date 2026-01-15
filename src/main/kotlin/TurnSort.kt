package com.github.lindsaygelle.dqbs

import java.util.*

class TurnSort(
    override var battleUUID: UUID,
    override var invokerUUID: UUID,
    override var score: Int,
    override var timeMilliseconds: Long,
    override var uuid: UUID,
    override var turn: Int,
) : InvokerIdentifier,
    Scorer,
    TurnTracer