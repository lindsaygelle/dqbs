package com.github.lindsaygelle.dqbs

import java.util.UUID

data class ActionEnd(
    override var actionUUID: UUID,
    override var invokerUUID: UUID,
    var result: Boolean,
    override var timeMilliseconds: Long,
    override var uuid: UUID
) : ActionTracer