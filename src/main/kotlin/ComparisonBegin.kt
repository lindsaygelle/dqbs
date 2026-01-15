package com.github.lindsaygelle.dqbs

import java.util.UUID

data class ComparisonBegin(
    override var attribute: Attribute,
    override var comparisonUUID: UUID,
    override var operation: Operation,
    override var receiverUUID: UUID,
    override var timeMilliseconds: Long,
    override var uuid: UUID,
    override var value: Int,
): ComparisonTracer
