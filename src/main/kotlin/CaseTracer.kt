package com.github.lindsaygelle.dqbs

import java.util.*

interface CaseTracer : InvokerIdentifier,
    Tracer {
    var caseUUID: UUID
}