package com.github.lindsaygelle.dqbs

import java.util.*

data class CaseSelect(
    val invokerUUID: UUID,
    val receiverUUID: UUID,
    val result: Boolean,
    val selection: Selection,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
) : CaseTracer