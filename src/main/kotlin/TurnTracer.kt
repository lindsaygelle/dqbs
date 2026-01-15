package com.github.lindsaygelle.dqbs

import java.util.*

interface TurnTracer : Tracer,
    TurnAccumulator {
    var battleUUID: UUID
}