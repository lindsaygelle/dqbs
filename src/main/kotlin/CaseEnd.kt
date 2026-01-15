package com.github.lindsaygelle.dqbs

import java.util.*

data class CaseEnd(
    override var caseUUID: UUID,
    override var invokerUUID: UUID,
    override var receiverCount: Int,
    override var timeMilliseconds: Long,
    override var uuid: UUID,
) : CaseTracer,
    ReceiverCounter