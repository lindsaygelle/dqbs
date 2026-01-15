package com.github.lindsaygelle.dqbs

import java.util.*

interface ComparisonTracer : Tracer {
    val attribute: Attribute
    val operation: Operation
    val receiverUUID: UUID
    val value: Int
}