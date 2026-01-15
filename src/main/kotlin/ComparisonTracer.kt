package com.github.lindsaygelle.dqbs

import java.util.*

interface ComparisonTracer : Attributer,
    Operator,
    ReceiverIdentifier,
    Tracer {
    var comparisonUUID: UUID
    var value: Int
}