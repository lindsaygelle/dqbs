package com.github.lindsaygelle.dqbs

import java.util.*

data class ComparisonEnd(
    override var attribute: Attribute,
    override var comparisonUUID: UUID,
    override var operation: Operation,
    override var receiverUUID: UUID,
    var receiverValue: Int,
    var result: Boolean,
    override var timeMilliseconds: Long,
    override var uuid: UUID,
    override var value: Int,
) : ComparisonTracer
