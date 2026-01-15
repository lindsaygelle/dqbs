package com.github.lindsaygelle.dqbs

import java.util.*

interface ActionTracer : InvokerIdentifier,
    Tracer {
    var actionUUID: UUID
}