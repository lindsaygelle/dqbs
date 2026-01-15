package com.github.lindsaygelle.dqbs

import java.util.*

interface AbilityTracer : InvokerIdentifier,
    Namer,
    Tracer {
    var abilityUUID: UUID
}