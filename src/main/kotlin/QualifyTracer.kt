package com.github.lindsaygelle.dqbs

import java.util.*

interface QualifyTracer : Tracer {
    val invokerUUID: UUID
    val receiverCount: Int
}