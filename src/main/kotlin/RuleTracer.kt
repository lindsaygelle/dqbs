package com.github.lindsaygelle.dqbs

import java.util.*

interface RuleTracer : Tracer {
    val match: Match
    val receiverUUID: UUID
}