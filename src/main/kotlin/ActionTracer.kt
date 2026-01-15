package com.github.lindsaygelle.dqbs

import java.util.*

interface ActionTracer : Tracer {
    val invokerUUID: UUID
}