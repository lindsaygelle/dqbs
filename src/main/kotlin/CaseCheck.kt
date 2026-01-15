package com.github.lindsaygelle.dqbs

import java.util.*

data class CaseCheck(
    override var caseUUID: UUID,
    override var count: Int,
    override var invokerUUID: UUID,
    override var receiverUUID: UUID,
    var result: Boolean,
    override var timeMilliseconds: Long,
    override var uuid: UUID,
) : CaseTracer,
    Counter,
    ReceiverIdentifier