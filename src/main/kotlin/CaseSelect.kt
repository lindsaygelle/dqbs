package com.github.lindsaygelle.dqbs

import java.util.*

data class CaseSelect(
    override var caseUUID: UUID,
    override var invokerUUID: UUID,
    override var receiverUUID: UUID,
    var result: Boolean,
    var selection: Selection,
    override var timeMilliseconds: Long,
    override var uuid: UUID,
) : CaseTracer,
    ReceiverIdentifier
