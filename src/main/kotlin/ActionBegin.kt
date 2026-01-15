package com.github.lindsaygelle.dqbs

import java.util.*

data class ActionBegin(
    override var actionUUID: UUID,
    override var invokerUUID: UUID,
    override var receiverCount: Int,
    override var timeMilliseconds: Long,
    override var uuid: UUID,
) : ActionTracer,
    ReceiverCounter,
    InvokerIdentifier
