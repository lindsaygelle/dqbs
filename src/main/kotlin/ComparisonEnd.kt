package com.github.lindsaygelle.dqbs

import java.util.*

data class ComparisonEnd(
    override var attribute: Attribute,
    override var operation: Operation,
    override var receiverUUID: UUID,
    val receiverValue: Int,
    val result: Boolean,
    override var timeMilliseconds: Long,
    override var uuid: UUID,
    override var value: Int,
) : ComparisonTracer