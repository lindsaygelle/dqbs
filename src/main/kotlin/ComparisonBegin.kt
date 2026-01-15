package com.github.lindsaygelle.dqbs

import java.util.*

data class ComparisonBegin(
    override val attribute: Attribute,
    override val operation: Operation,
    override val receiverUUID: UUID,
    override val timeMilliseconds: Long,
    override val uuid: UUID,
    override val value: Int,
) : ComparisonTracer