package com.github.lindsaygelle.dqbs

import java.util.UUID

data class TurnEnd(
    override var battleUUID: UUID,
    override var timeMilliseconds: Long,
    override var turn: Int,
    override var uuid: UUID,
): TurnTracer